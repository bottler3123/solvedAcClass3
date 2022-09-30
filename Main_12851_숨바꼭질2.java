package algorithm;

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
		int routeCnt = 0;
		que.offer(new int [] {N,cnt});
		
		
		while (!que.isEmpty()) {
			int [] temp = que.poll();
			N = temp[0];
			cnt = temp[1];
					
			if (N == K) {
				if (small == 0) {
					small = cnt;
				}
				if (small == cnt) {
					routeCnt++;
				}
				continue;
			}
			if (N > 0 && N < 100000) {
				if (!map[N+1]) {
					que.offer(new int [] {N+1,cnt+1});
					map[N+1] = true;
				}
				if (!map[N-1]) {
					que.offer(new int [] {N-1,cnt+1});
					map[N-1] = true;
				}				
			}
			if (N < 5001 && N != 0) {
				if (!map[N*2]) {
					que.offer(new int [] {N*2,cnt+1});
					map[N*2] = true;
				}				
			}
		}

		System.out.println(cnt + " " + routeCnt);
	}
}
