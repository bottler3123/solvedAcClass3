package practice;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt(); // 목표액
		
		int[] D = new int[money+1]; // D[i] : i금액을 만드는 최소 동전수
		
		int INF = Integer.MAX_VALUE;
		D[0] = 0;
		
		for (int i = 1; i <= money; i++) {
			int min = INF;
			min = Math.min(min, D[i-1] + 1);
			if (i>=4) min = Math.min(min, D[i-4]+1);
			if (i>=6) min = Math.min(min, D[i-6]+1);
			
			D[i] = min;
		}
		System.out.println(Arrays.toString(D));
		System.out.println(D[money]);
	}
}
