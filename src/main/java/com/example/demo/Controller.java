package com.example.demo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.source.tree.BinaryTree;
@RestController
public class Controller {
	@GetMapping("/demo")
	public String demo() {
		return "데모 리턴";
	}
	@GetMapping("/demoapi")
	public Map<String,Object> demoapi(){
		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("birthdday",940813);
		return map;
	}
	@GetMapping("/List")
	public List<String> List(String[] arr){
		List<String> l = new ArrayList<String>();
		l.add("제니퍼");
		l.add("제니퍼1");
		l.add("제니퍼2");
		l.add("제니퍼3");
		l.add("제니퍼4");
		
		return l;
		/*
		 * for(String str:arr) { System.out.println(str); }
		 */
	}

}
