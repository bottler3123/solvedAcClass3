package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_12851_숨바꼭질2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean [] map = new boolean [100001];
		Queue<int[]> que = new LinkedList<>();
		int cnt = 0;
		int small = 0;
		int [] routeCnt = new int [100001];
		que.offer(new int [] {N,cnt});
		map[N] = 1;
		
		
		while (!que.isEmpty()) {
			int [] temp = que.poll();
			N = temp[0];
			cnt = temp[1];
					
			if (N == K) {
				small = map[N];
				routeCnt++;
				return;
			}
			if (N > 0 && N < 100000) {
				if (map[N+1] == 0) {
					que.offer(new int [] {N+1,cnt+1});
					map[N+1] = map[N] + 1;
				}
				if (map[N-1] == 0) {
					que.offer(new int [] {N-1,cnt+1});
					map[N-1] = map[N] + 1;
				}				
			}
			if (N < 5001 && N != 0) {
				if (map[N*2] == 0) {
					que.offer(new int [] {N*2,cnt+1});
					map[N*2] = map[N] + 1;
				}				
			}
		}

		System.out.println(cnt + " " + routeCnt);
	}
}