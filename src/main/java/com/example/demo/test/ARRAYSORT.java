package com.example.demo.test;


import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class ARRAYSORT {
	public static void main(String[] arsgs) {
	
		Scanner sc = new Scanner(System.in);
		int insert = sc.nextInt();
		int[] arr = new int[insert];
		int cnt =0;

		for(int i =0;i<insert;i++) {
			int num=sc.nextInt();
			arr[i]=num;
			
		}
		Arrays.sort(arr);
		for(int val:arr) {
			System.out.println(val);
		}
		
		
	}
}
