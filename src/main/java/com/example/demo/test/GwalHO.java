package com.example.demo.test;

import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class GwalHO {
	public static void Main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int I = sc.nextInt();
		int cnt=0;
		for(int i=0;i<I;i++) {
			System.out.println(solve(sc.next()));
		}
	}
	static String solve(String s) {
		
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			char c =s.charAt(i);
			if(c=='(') {
				st.push(c);
			}else if(st.empty()) {
				return "NO";
			}else {
				st.pop();
			}
		}
		if(st.empty()) {
			return "YES";
		}
		else {
		return "NO";
		}
	}
}
