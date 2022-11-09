package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2531_회전초밥 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		int [] table = new int [N+k+1];
		boolean [] susi;
		for (int i = 1; i <= N; i++) {
			table[i] = sc.nextInt();
		}
		for (int i = 1; i <= k; i++) {
			table[i+N] = table[i];
		}
		
		int ans = 0;
		for (int i = 1; i < N+1; i++) {
			boolean check = false;
			int cnt = 0;
			susi = new boolean [d+1];
			for (int j = i; j < i+k; j++) {
				if (!susi[table[j]]) {
					susi[table[j]] = true;
					if (table[j] == c) {
						check = true;
					}
					cnt++;
				}
			}
			if (check) {
				ans = Math.max(ans, cnt);
			} else {
				ans = Math.max(ans, cnt+1);				
			}
//			System.out.println(i + "까지 " + cnt + "그릇 먹음");
		}
		
		
//		System.out.println();
//		System.out.println(Arrays.toString(table));
		System.out.println(ans);
	}
}
