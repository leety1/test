package Example;

import java.util.Scanner;

public class tangent {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int t  = sc.nextInt();
	
	while(t-->0) {
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		
		int a1=sc.nextInt();
		int b1=sc.nextInt();
		int c1=sc.nextInt();
		System.out.println(tangent_point(a,b,c,a1,b1,c1));
	}
	}
	public static int tangent_point(int a,int b,int c,int a1,int b1,int c1) {
		int distance =(int)(Math.pow(a1-a, 2)+Math.pow(b1-b, 2));
		
		if(a==a1 && b==b1&&c==c1) {
			return -1;
		}else if(distance>Math.pow(b+b1, 2)) {
			return 0;
		}else if(distance<Math.pow(b-b1, 2)) {
			return 0;
		}else if(distance==Math.pow(b-b1, 2)) {
			return 1;
		}else if(distance==Math.pow(b+b1, 2)) {
			return 1;
		}else {
			return 2;
		}
		
		
	}
}
