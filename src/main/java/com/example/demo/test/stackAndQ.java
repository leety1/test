package com.example.demo.test;

import java.util.*;
import java.util.Arrays;
public class stackAndQ {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int k=sc.nextInt();
		int sum=0;
		
		for(int i =0;i<k;i++) {
			int num=sc.nextInt();
			if(num==0) {
				stack.pop();
			}else {
				stack.push(num);
			}
		}
		for(int o:stack) {
			sum+=o;
		}
		System.out.println(sum);
		
		
//		int a =sc.nextInt();
//		int[] arr = new int[a];
//		int cnt=-1;
//		for(int c=0;c<a;c++) {
//			
//			int num = sc.nextInt();
//			
//			if(num==0) {
//				cnt--;
//			}else  {
//				cnt++;
//				arr[cnt] = num;
//			}
//		}
//		int sum=0;
//		for(int i=0;i<=cnt;i++) {
//			sum+=arr[i];
//		}
//	
//		System.out.println(sum);
		
		
		
		
	}

}
