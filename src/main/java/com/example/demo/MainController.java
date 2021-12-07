package com.example.demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.*;
import com.sun.source.tree.BinaryTree;
import java.util.Map.Entry;
import com.example.demo.config.TestConfig;
import com.example.demo.login.UserEntity;
import com.example.demo.login.UserRepository;


@Controller
public class MainController {
	
	@Autowired
	TestConfig testConfig;

	@GetMapping("/Login")
	public String getIndex() {
		
		return "LoginPage";
	}
	@GetMapping("/index")
	public String getLoginForm() {
		return "index";
	}
	@Autowired
	private UserRepository userReposi;
	@Autowired
	private PasswordEncoder passEncoder;
	@GetMapping("/signUp")
	public String signUp() {
		return "signUp";
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
	
	
	
	
	
	
}
