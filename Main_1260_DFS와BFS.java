package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

	static int [][] Gragh;
	static boolean [] check;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		Gragh = new int [N+1][N+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Gragh[x][y] = Gragh[y][x] = 1;
		}
		check = new boolean [N+1];
		dfs(V,N);
		System.out.println("");
		check = new boolean [N+1];
		bfs(V, N);
	}
	
	public static void dfs(int V, int N) {
		check[V] = true;
		System.out.print(V + " ");
		
		for (int i = 1; i < N+1; i++) {
			if(Gragh[V][i] == 1 && !check[i]) {
				dfs(i, N);	
			}
		}
	}
	
	public static void bfs(int V, int N) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(V);
		check[V] = true;
		
		while (!que.isEmpty()) {
			int temp = que.poll();
			System.out.print(temp + " ");
			
			for (int i = 1; i < N+1; i++) {
				if(Gragh[temp][i] == 1 && !check[i]) {
					que.add(i);
					check[i] = true;
				}
			}
		}
	}
}
