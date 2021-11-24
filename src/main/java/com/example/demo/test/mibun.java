package com.example.demo.test;

import java.util.Scanner;

public class mibun {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			double r = sc.nextDouble();
			sc.close();
			double Pi = r*r*Math.PI;
			String s = Double.toString(Pi);
			System.out.println(s.substring(0,6));
			System.out.println(2*r*r);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
