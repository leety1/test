package com.example.demo.test;
import java.util.*;
public class arrlist {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] Oarr = new int[x];
		int[] Sarr = new int[x];
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<x;i++) {
			Sarr[i]=Oarr[i]=sc.nextInt();
		}
		Arrays.sort(Sarr);
		
		int rank = 0;
		for(int v:Sarr) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int key:Oarr) {
			int ranking = rankingMap.get(key);
			sb.append(ranking).append(' ');
		}
		System.out.println(sb);
	}

}
