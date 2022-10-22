package solvedac_class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {

	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int M,N,K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int [][] map = new int [M][N];
			boolean [][] check = new boolean [M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			int ans = 0;
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 0 && !check[r][c]) {
						check[r][c] = true;
					} else if(map[r][c] == 1 && !check[r][c]) {
						ans++;
						Queue<int[]> que = new LinkedList<>();
						que.add(new int[] {r,c});
						
						while (!que.isEmpty()) {
							int [] temp = que.poll();
							int x = temp[0];
							int y = temp[1];
							check[x][y] = true;
//							debug
//							System.out.println("x좌표: "+x+" y좌표: "+y+" 배추벌레수: "+ans);
							
							for (int i = 0; i < 4; i++) {
								int nextx = x + dx[i];
								int nexty = y + dy[i];
								
								if (nextx <0 || nextx >= M || nexty < 0 || nexty >= N || check[nextx][nexty] ) continue;
								if (map[nextx][nexty] == 0) continue;
								que.add(new int[] {nextx,nexty});
								check[nextx][nexty] = true;
							}
						}
					}
				}
			}

			System.out.println(ans);
		}
	}
}
