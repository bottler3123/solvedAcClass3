package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			boolean[][] check = new boolean[N][N];
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				check[x][y] = true;
			}

			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					for (int c = 0; c < N; c++) {
						if (check[b][a] && check[a][c]) {
							check[b][c] = true;
						}
					}
				}
			}

			int[] cnt = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (check[i][j] || check[j][i])
						cnt[i]++;
				}
			}

			int ans = 0;
			for (int i : cnt) {
				if (i == N - 1)
					ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
