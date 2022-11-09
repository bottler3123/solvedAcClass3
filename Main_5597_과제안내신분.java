package practice;

import java.util.Scanner;

public class Main_5597_과제안내신분 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean [] student = new boolean [31];
		for (int i = 0; i < 28; i++) {
			int a = sc.nextInt();
			student[a] = true;
		}
		
		for (int i = 1; i < 31; i++) {
			if (!student[i]) {
				System.out.println(i);
			}
		}
	}
}
