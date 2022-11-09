package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자ver2 {

	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][][] check;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		check = new boolean[N][M][64];
		int startx = 0;
		int starty = 0;
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					startx = i;
					starty = j;
				}
			}
		}

		Queue<int[]> que = new LinkedList<int[]>();
		check[startx][starty][0] = true;
		que.add(new int [] {startx,starty,0,0});
		int ans = Integer.MAX_VALUE;

		while (!que.isEmpty()) {

			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			int key = temp[2];
			int move = temp[3];
			System.out.println("x: " + x + " y: " + y + " move: " + move + " key: " + key);
			
			if (map[x][y] == '1') {
				ans = ans > move ? move : ans;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				
				if(wallCheck(nextx,nexty)) continue; 
				if(check[nextx][nexty][key]) continue;
				if(keyCheck(nextx,nexty,key)) continue;
				int nextkey = getKey(nextx,nexty,key);
				que.add(new int [] {nextx,nexty,nextkey,move+1});
				check[nextx][nexty][key] = true;
			}
		}
		
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);			
		}

	}


	public static boolean wallCheck(int nextx, int nexty) {
		if (nextx < 0 || nextx >= N || nexty < 0 || nexty >= M || map[nextx][nexty] == '#') {
			return true;
		}
		return false;
	}
	
	private static int getKey(int nextx, int nexty, int key) {
		int dropKey = map[nextx][nexty] - 'a';
		if (0 <= dropKey && 6 > dropKey) {
			return key |= (1 << dropKey);
		} else {
			return key;
		}
	}
	
	public static boolean keyCheck(int nextx, int nexty, int key) {
		int door = map[nextx][nexty] - 'A';
		if (0 <= door && 6 > door) {
			if ((key & (1 << door)) > 0) {
				return false;
			}
			return true;
		}
		return false;
	}
}
