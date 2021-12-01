package com.example.demo.test;


import java.util.Scanner;
import java.util.*;

public class SangSu {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a=  sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		if(a!=b) {
			a = Integer.parseInt(new StringBuilder().append(a).reverse().toString());
			b = Integer.parseInt(new StringBuilder().append(a).reverse().toString());
			
			System.out.println(a);
		}
		
	}
}
