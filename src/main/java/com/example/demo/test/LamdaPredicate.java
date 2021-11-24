package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LamdaPredicate {
	public static void main(String[] args) {
		Predicate<String> non = (String s) -> !s.isEmpty();
		
		
		List<String> listofS = Arrays.asList("green","red","");
		List<String> nonEmp = filter(listofS,non);
		
		System.out.println(nonEmp);
		
		Consumer<MyNumber> c4 = num ->System.out.println(num.getNum());
		c4.accept(new MyNumber() {
			
			@Override
			public int getNum() {
				// TODO Auto-generated method stub
				return 100;
			}
		});
		
		c4.accept(()->{
			return 200;
		});
		//Element는 요소로 의미 해석 ArrayList는 요소들을(오브젝트) 배열처럼 저장 E로 선언
		//컬렉션 클래스와 배열기반은 E 그 외는 T
	
		Each(Arrays.asList(1,2,3,4,5),(Integer i)->System.out.println(i));
		
	}
	
	static<T> List<T> filter(List<T> list,Predicate<T> p){
		List<T> rst = new ArrayList<>();
		for(T s :list) {
			if(p.test(s)) {
				rst.add(s);
			}
		}
		return rst;
		
	}
	static<T> void Each(List<T> list,Consumer<T> c) {
		for(T i : list) {
			c.accept(i);
		}
	}	

}
