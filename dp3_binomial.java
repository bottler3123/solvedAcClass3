package practice;

import java.util.Scanner;

public class dp3_binomial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] B = new int [N+1][K+1];
		
		for (int i = 0; i <= N; i++) {
			int end = Math.min(i, K);
			for (int j = 0; j <= end; j++) {
				if(j==0 || j==i) {
					B[i][j] = 1;
				} else {
					B[i][j] = B[i-1][j-1] + B[i-1][j];
				}
			}
		}
		
		System.out.println(B[N][K]);
	}
}
