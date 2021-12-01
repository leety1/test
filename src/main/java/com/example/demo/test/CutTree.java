package com.example.demo.test;


import java.util.*;
public class CutTree {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b= sc.nextInt();
		
		int[] tree = new int[a];
		
		int m = 0;
		int M = 0;
		
		for(int i=0;i<tree.length;i++) {
			tree[i] = sc.nextInt();
		
			if(M<tree[i]) {
				M=tree[i];
			}
		}
		while(m<M) {
			int mid = (m+M)/2;
			long sum =0;
			for(int height : tree) {
				if(height - mid >0) {
					sum += (height-mid);
				}
			}
			if(sum<M) {
				m=M;
			}else {
				m=mid +1;
			}
		}
		System.out.println(m-1);
	}
	
}
