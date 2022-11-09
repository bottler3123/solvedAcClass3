package practice;

import java.util.Scanner;

public class Main_9086_문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			String str = sc.next();
			System.out.print(str.charAt(0));
			System.out.println(str.charAt(str.length()-1));
		}
	}
}
