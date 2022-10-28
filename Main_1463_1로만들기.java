package solvedac_class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1463_1로만들기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(N);
		
		while (!que.isEmpty()) {
			int size = que.size();
			
			for (int i = 0; i < size; i++) {
				int num = que.poll();
				
				if (num == 1) {
					System.out.println(cnt);
					que.clear();
					break;
				}
				if (num%3 == 0) {
					que.add(num/3);
				}
				if (num%2 == 0) {
					que.add(num/2);
				}
				que.add(num-1);
			}
			
			cnt++;
		}
	}
}
