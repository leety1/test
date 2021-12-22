package com.example.demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Spliterator;
import com.example.demo.kafka.KafkaSampleProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.*;
import com.sun.source.tree.BinaryTree;

import lombok.extern.log4j.Log4j2;

import java.util.Map.Entry;

import com.example.demo.Redis.RedisSampleService;
import com.example.demo.config.TestConfig;
import com.example.demo.domain.UserEntity;
import com.example.demo.domain.UserRepository;
import com.example.demo.domain.UserinfoDto;
import com.example.demo.login.UserSerive;


@Controller
@Log4j2
public class MainController {
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private PasswordEncoder paEnc;
	@Autowired
	TestConfig testConfig;
	@Autowired
	private UserSerive uservice;
	
	@RequestMapping({"/hello"})
	public String firstPage() {
		return "Hello World";
	}
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(Locale locale, Model model) {
        return "chat";
    }
	@GetMapping("/Login")
	public String getIndex() {
		
		return "LoginPage";
	}
	@GetMapping("/index")
	public String getLoginForm() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			String username = ((UserDetails)principal).getUsername();
			System.out.println(username);
		}else{
			String username = principal.toString();
			System.out.println(username+"이건 else");
		}
		return "index";
	}
//	@PostMapping("/user")
//	public String signup(UserinfoDto userDto) {
//		uservice.save(userDto);
//		return "redirect:/login";
//	}
	
	@PostMapping("/user")
	public String signUp(UserEntity ue) {
		Map<String, Object> map = new HashMap<>();
		UserEntity user  = UserEntity.builder()
				.name(ue.getName())
				.password(ue.getPassword())
				.role(ue.getRole())
				.build();
		System.out.println(ue.getName()+"\n");
		System.out.println(ue.getPassword()+"\n");
		System.out.println(ue.getRole()+"\n");
		
		uRepo.save(user);
		
		return "redirect:/login";
	}
	
	@GetMapping("/demoapi")
	public Map<String,Object> demoapi(){
		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("birthdday",940813);
		return map;
	}
	@GetMapping("/Chart")
	public String Chart(){
		return "Graph";
		/*
		 * for(String str:arr) { System.out.println(str); }
		 */
	}
	@GetMapping("/Chart/bar")
	public String ChartBar(){
		return "bar";
		/*
		 * for(String str:arr) { System.out.println(str); }
		 */
	}
//	@GetMapping("/socket")
//	public String RTC(){
//		log.info("@MainController,socket GET()");
//		return "index3";
//		/*
//		 * for(String str:arr) { System.out.println(str); }
//		 */
//	}
	@GetMapping("/arr")
	public Stream<String> arr() {
		String[] arr = new String[] {"a","b","c"};
		Stream<String> str = Arrays.stream(arr);
		
		Stream<String> strArr = Arrays.stream(arr,1,3);
		return strArr;
	}
	@RequestMapping(method = RequestMethod.GET,path="/index2")
	public @ResponseBody Stream<String> index2() {
		ArrayList<String> li = new ArrayList<>(Arrays.asList("Apple","Banana","Melon"));
		Stream<String> str = li.stream();
		//return 에 결과값만 잘 너어주면 돼 string 형식으로
		li.stream().map(a->a.toUpperCase()).collect(Collectors.joining(" "));
		li.stream().map(String::toUpperCase);
		li.stream().filter(t->t.length()>5);
		return li.stream().map(a->a.toUpperCase());
	}
//	@RequestMapping("/video")
//	public @ResponseBody String ind2() throws Exception {
//		return "index2";
//	}
	@RequestMapping("/map")
	public  @ResponseBody HashMap<Object, Object> in3() throws Exception{
		var map = new HashMap<>();
		map.put(1, "key");
		for(Entry<Object, Object> ent : map.entrySet()) {
			System.out.println("[Key]:"+ent.getKey()+"[val]:"+ent.getValue());
			
		}
		return map;
	}
	
	/*
	 * @Autowired private UserRepository userRepo;
	 */
	
	//Kafka 컨트롤러
	@Autowired
	private KafkaSampleProducerService kafkaSampleProducerService;
	@PostMapping(value = "/sendMessage")
	public void sendMessage(String message) {
		kafkaSampleProducerService.sendMessage(message);
	}
	//REDIS 컨트롤
	@Autowired
	private RedisSampleService redisSampleService;
	@PostMapping(value = "/getRedisStringValue")
	public void getRedisStringValue(String key,String value) {
	redisSampleService.getRedisStringValue(key,value);
	}	
}
