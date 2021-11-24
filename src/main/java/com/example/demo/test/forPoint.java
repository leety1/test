package com.example.demo.test;

import java.util.Scanner;

public class forPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {sc.nextInt(),sc.nextInt()};
		int[] b = {sc.nextInt(),sc.nextInt()};
		int[] c = {sc.nextInt(),sc.nextInt()};
		
		sc.close();
		int x = 0;
		int y=0;
		if(a[0]==b[0]) {
			x=c[0];
		}else if(a[0]==c[0]) {
			x=b[0];
		}else if(b[0]==c[0]) {
			x=a[0];
		}
		if(a[1]==b[1]) {
			y=c[1];
		}else if(a[1]==c[1]) {
			y=b[1];
		}else if(b[1]==c[1]) {
			y=a[1];
		}
		
		System.out.println(x+" "+y);
	}

}
