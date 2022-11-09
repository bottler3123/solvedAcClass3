package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16953_AtoB {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		int cnt = 0;
		
		Queue<Long> que = new LinkedList<>();
		que.add(A);
		int ans = -1;
		
		while (!que.isEmpty()) {
			int size = que.size();
//			System.out.println("숫자 :" + num + " 이동횟수 :" + cnt);
			boolean check = false;
			
			for (int i = 0; i < size; i++) {
				long num = que.poll();
				if (num == B) {
					ans = cnt+1;	
					check = true;
					break;
				}
				
				if (num*2 <= B && num*2 > 0) {
					que.add(num*2);			
				}
				if (num*10+1 <= B && num*10+1 > 0) {
					que.add(num*10+1);
				}
			}
			cnt++;
			
			if (check) {
				break;
			}
		}

			System.out.println(ans);
	}
}
