package solvedac_class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(in.readLine());
		int connect = Integer.parseInt(in.readLine());
		boolean [][] line = new boolean [com+1][com+1];
		for (int i = 0; i < connect; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			line[start][end] = line[end][start] = true;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		boolean [] computer = new boolean [com+1];
		que.add(1);
		int ans = 0;
		computer[1] = true;
		
		while (!que.isEmpty()) {
			int temp = que.poll();
			
			for (int i = 0; i < com+1; i++) {
				if (line[temp][i]) {
					if (!computer[i]) {
						que.add(i);
						computer[i] = true;
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
