package com.example.demo.test;

public class ex2Cat {
	private final String name;
	private int cnt;
	public ex2Cat(String id) {
		name=id;
	}
	public void increment() {
		cnt++;
	}
	public int tally() {
		return cnt;
	}
	public String toString() {
		return cnt+" " +name;
	}
	public static void main(String[] args) {
		ex2Cat heads = new ex2Cat("Heads");
		ex2Cat tails = new ex2Cat("tails");
		heads.increment();
		heads.increment();
		tails.increment();
		
		System.out.println(heads+" "+tails);
		System.out.println(heads.tally()+" "+tails.tally());
		
	}
}
