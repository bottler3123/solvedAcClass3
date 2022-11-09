package practice;

import java.util.Scanner;

public class Main_2908_상수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int reA = A/100 + A%100/10*10 + A%100%10*100;
		int reB = B/100 + B%100/10*10 + B%100%10*100;
		System.out.println(Math.max(reA, reB));
	}
}
