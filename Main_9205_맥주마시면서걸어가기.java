package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(in.readLine());
			int [][] location = new int [n+2][2];
			for (int i = 0; i < n+2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}
			
		boolean [] check = new boolean [n+2];
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int [] {location[0][0],location[0][1]});
		check[0] = true;
		String ans = "sad";
		
		while (!que.isEmpty()) {
			int [] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			
			if (x == location[n+1][0] && y == location[n+1][1]) {
				ans = "happy";
			}
			for (int i = 1; i < n+2; i++) {
				if (check[i]) continue;
				int nextx = location[i][0];
				int nexty = location[i][1];
				if (Math.abs(nextx-x) + Math.abs(nexty-y) > 1000) continue;
				que.add(new int [] {nextx,nexty});
				check[i] = true;
			}
		}
		
		System.out.println(ans);
		}
	}
}


