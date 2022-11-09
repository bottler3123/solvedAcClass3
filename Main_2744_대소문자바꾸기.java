package practice;

import java.util.Scanner;

public class Main_2744_대소문자바꾸기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			char change = str.charAt(i);
			if (change < 97) {
				change += 32;
				System.out.print(change);
			} else {
				change -= 32;
				System.out.print(change);				
			}
		}
	}
}
