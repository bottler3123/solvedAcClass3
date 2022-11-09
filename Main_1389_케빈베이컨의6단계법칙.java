package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean [][] relation = new boolean [N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x][y] = true;
			relation[y][x] = true;
		}
		
		int bacon = Integer.MAX_VALUE;
		int ans = 0;
		
		for (int i = 1; i <= N; i++) {
			
			Queue<int[]> que = new LinkedList<int[]>();
			que.add(new int [] {i,0});
			boolean check [] = new boolean [N+1];
			check[i] = true;
			
			int cevin = 0;
			while (!que.isEmpty()) {
				int [] temp = que.poll();
				int man = temp[0];
				int cnt = temp[1];
				cevin += cnt;
//				System.out.println(i + "번 친구와 " + man + "의 케빈베이컨 수 : " + cnt);
//				System.out.println(Arrays.toString(check));
//				System.out.println("");
				
				for (int j = 1; j <= N; j++) {
					if (relation[man][j] && !check[j]) {
						que.add(new int [] {j,cnt+1});		
						check[j] = true;
					}
				}
			}
			
//			System.out.println("freind : " + i + " cevin : " + cevin);
			if (bacon > cevin) {
				bacon = cevin;
				ans = i;
			}
		}
		
		System.out.println(ans);
	}
}
