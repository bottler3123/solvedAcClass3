package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {

	static int [] dx = new int [] {-1,0,1,0};
	static int [] dy = new int [] {0,1,0,-1};
	static char [][] map;
	static boolean [][][] check;
	static int N,M,x,y,key,move;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		check = new boolean [N][M][64];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					x = i;
					y = j;
				}
			}
		}
		Stack<int[]> stack = new Stack<>();
		stack.add(new int [] {x,y,key,move});
		check[x][y][key] = true;
		System.out.println("check: " + check[5][1][3]);
		
//		시작 좌표값
//		System.out.println("start x : " + x + " start y: " + y);
		int ans = Integer.MAX_VALUE;
		
		while (!stack.isEmpty()) {
			int [] temp = stack.pop();
			x = temp[0];
			y = temp[1];
			key = temp[2];
			move = temp[3];
			getKey(x, y);
			
//			좌표 디버깅
			System.out.println("x: " + x + " y: " + y + " move: " + move + " key: " + key);
			if (map[x][y] == '1') {
				if (move < ans) {
					ans = move;
					System.out.println("답: " + ans);
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				
				if (wall(nextx,nexty)) continue;
				System.out.println("after check: " + check[nextx][nexty][key]);
				if (check[nextx][nexty][key]) continue;
				System.out.println("before check: " + check[nextx][nexty][key]);
				if (opendoor(nextx,nexty)) continue;
				check[nextx][nexty][key] = true;
				stack.add(new int [] {nextx,nexty,key,move+1});
				
			}
		}
		
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.print(ans);
	}
	
	
	public static boolean wall(int nextx,int nexty) {
		if (nextx <0|| nextx >= N || nexty <0 || nexty >=M || map[nextx][nexty] =='#') {
			return true;
		}
		return false;
	}
	
	public static void getKey(int x, int y) {
		if (0 <= map[x][y] -'a' && map[x][y] - 'a' < 6) {
			key |= (1 << (map[x][y] -'a'));
//			check[x][y][key] = true;
		}
	}
	
	public static boolean opendoor(int nextx, int nexty) {
		int door = map[nextx][nexty] -'A';
		if (0 <= door && door < 6) {
//			System.out.println("gate: " + (map[nextx][nexty] -'A'));
//			System.out.println("key: " + (key & (1 << door)));
			if ((key & (1 << door)) == (1<< door)) {
				return false;
			}
			return true;
		}
		return false;
	}
}
