package solvedac_class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

	static int [] dx = {0,0,-1,1};
	static int [] dy = {1,-1,0,0};
	static boolean check[][];
	static int map [][];
	static int N,M,ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map= new int [N][M];
		check = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int [] {0,0,1});
		check[0][0] = true;
		
		while (!que.isEmpty()) {
			int [] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			int movecnt = temp[2];
//			System.out.println(x + " " + y);
			
			if (x == N-1 && y == M-1) {
				System.out.println(movecnt);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int movex = x + dx[i];
				int movey = y + dy[i];
				
				if (movex < 0 || movex >= N || movey < 0 || movey >= M ) continue;
				if (map[movex][movey] == 0 || check[movex][movey]) continue;
				que.add(new int [] {movex,movey,movecnt+1});
				check[movex][movey] = true;
				
			}
		}
//		System.out.println(Arrays.deepToString(map));
	}
}
