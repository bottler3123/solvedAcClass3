package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [][] map = new int [N][M];
		int cheese = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheese ++;
			}
		}
		int meltCnt = 0;
		int lastCheese = cheese;
		
		while (cheese > 0) {
			boolean [][] check = new boolean [N][M];
			Queue<int[]> que = new LinkedList<int[]>();
			que.add(new int[] {0,0});
			
			while (!que.isEmpty()) {
				int[] temp = que.poll();
				int x = temp[0];
				int y = temp[1];
				
				for (int i = 0; i < 4; i++) {
					int nextx = x + dx[i];
					int nexty = y + dy[i];
					
					if (wallCheck(nextx, nexty)) continue;
					if (check[nextx][nexty]) continue;
					if (map[nextx][nexty] == 1) {
						map[nextx][nexty] = 0;
						cheese --;
						check[nextx][nexty] = true;
						continue;
					}
					que.add(new int [] {nextx,nexty});
					check[nextx][nexty] = true;
				}
				
			}
			
//			map 디버깅
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
			meltCnt++;
			if (cheese != 0) {
				lastCheese = cheese;
			}
		}
		
		System.out.println(meltCnt);
		System.out.println(lastCheese);
	}

	public static boolean wallCheck(int nextx, int nexty) {
		if (nextx < 0 || nextx >= N || nexty < 0 || nexty >= M) {
			return true;
		}
		return false;
	}
}
