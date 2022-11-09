package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_보급로 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int[][] check = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check[i][j] = -1;
				}
			}
			Queue<int[]> que = new LinkedList<int[]>();
			que.add(new int [] {0,0,0});
			check[0][0] = 0;
			
			while (!que.isEmpty()) {
				int [] temp = que.poll();
				int x = temp[0];
				int y = temp[1];
				int time = temp[2];
//				System.out.print(x + " " + y + " " + time);
//				System.out.println("");
				
				for (int i = 0; i < 4; i++) {
					int nextx = x + dx[i];
					int nexty = y + dy[i];
					if (nextx < 0 || nextx >= N || nexty < 0 || nexty >= N) continue;
					
					int nexttime = time + map[nextx][nexty];
					if (check[nextx][nexty] == -1) {
						que.add(new int [] {nextx,nexty,nexttime});
						check[nextx][nexty] = nexttime;
					} else if (check[nextx][nexty] > nexttime) {
						que.add(new int [] {nextx,nexty,nexttime});
						check[nextx][nexty] = nexttime;
					}
				}
			}
			
			System.out.println("#"+t+" " + check[N-1][N-1]);
//			System.out.println(Arrays.deepToString(map));
//			System.out.println(Arrays.deepToString(check));
		}
	}
}
