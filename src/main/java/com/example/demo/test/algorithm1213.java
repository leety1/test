package com.example.demo.test;

import java.util.*;

public class algorithm1213 {
	public static void main(String[] args) {
	
	Scanner sc  = new Scanner(System.in);	
	int x = sc.nextInt();//kg 배달
	sc.close();
	if(x==4 || x==7) {
		System.out.println(-1);
	}
	else if(x%5==0) {
		System.out.println(x/5);
	}
	else if(x%5==1 || x%5 ==3) {
		System.out.println((x/5)+1);
	}else if(x%5==2||x%5 ==4) {
		System.out.println((x/5)+2);
	}
}
}
