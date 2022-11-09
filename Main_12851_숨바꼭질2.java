package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_12851_숨바꼭질2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] map = new int [100001];
		Queue<int[]> que = new LinkedList<>();
		int cnt = 0;
		int small = Integer.MAX_VALUE;
		int ans = 0;
		que.offer(new int [] {N,cnt});
		map[N] = 1;
		
		while (!que.isEmpty()) {
			int [] temp = que.poll();
			N = temp[0];
			cnt = temp[1];
//			debug
//			System.out.println("N : " + N + " cnt : " + cnt);
			
			if (N == K) {
				if (small > cnt) {
					small = cnt;
					ans = 1;
				} else if (small==cnt) {
					ans ++;
				}
			}
			
			int rightN = N + 1;
			int leftN = N - 1;
			int jumpN = N * 2;
			
			if (rightN >= 0 && rightN <= 100000) {
				if (map[rightN] == 0) {
					que.add(new int [] {rightN,cnt+1});
					map[rightN] = cnt+1;
				} else if (map[rightN] >= cnt + 1) {
					que.add(new int [] {rightN,cnt+1});
					map[rightN] = cnt+1;
				}
			}
			if (leftN >= 0 && leftN <= 100000) {
				if (map[leftN] == 0) {
					que.add(new int [] {leftN,cnt+1});
					map[leftN] = cnt+1;
				} else if (map[leftN] >= cnt + 1) {
					que.add(new int [] {leftN,cnt+1});
					map[leftN] = cnt+1;
				}
			}
			if (jumpN >= 0 && jumpN <= 100000) {
				if (map[jumpN] == 0) {
					que.add(new int [] {jumpN,cnt+1});
					map[jumpN] = cnt+1;
				} else if (map[jumpN] >= cnt + 1) {
					que.add(new int [] {jumpN,cnt+1});
					map[jumpN] = cnt+1;
				}
			}

		}

		System.out.println(small);
		System.out.println(ans);
	}
}