package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {

	static int N;
	static int[] area;
	static List<Integer> groupA;
	static List<Integer> groupB;
	static int[] areaComb;
	static boolean[][] connect;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		area = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			area[i] = Integer.parseInt(st.nextToken());
		}
		connect = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int con = Integer.parseInt(st.nextToken());
				connect[i][con] = connect[con][i] = true;
			}
		}
		
//		for (int i = 0; i < N+1; i++) {
//			for (int j = 0; j < N+1; j++) {
//				System.out.print(connect[i][j] + " ");
//			}
//			System.out.println("");
//		}
		
		for (int i = 1; i <= N/2 ; i++) {
			areaComb = new int[i];
			comb(0, 1, i);			
		}
		if (ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
		System.out.println(ans);
		}

	}

	public static void comb(int start, int cnt, int numcase) {
		if (start == numcase) {
//			System.out.println(Arrays.toString(areaComb));
			half();
			return;
		}
		for (int i = cnt; i <= N; i++) {
			areaComb[start] = i;
			comb(start + 1, i + 1, numcase);
		}
	}

	public static void half() {
		LinkedList<Integer> list = new LinkedList<>();
		groupA = new ArrayList<>();
		groupB = new ArrayList<>();
		for (int i = 0; i < areaComb.length; i++) {
			list.add(areaComb[i]);
		}
//		System.out.println(list.toString());
		for (int i = 1; i < N + 1; i++) {
			if (list.contains(i)) {
				groupA.add(i);
			} else {
				groupB.add(i);
			}
		}

//		debug
//		System.out.println("A그룹 : " + groupA.toString());
//		System.out.println("B그룹 : " + groupB.toString()+"\n");

		bfs();
	}

	private static void bfs() {
		Queue<Integer> queA = new LinkedList<Integer>();
		Queue<Integer> queB = new LinkedList<Integer>();
		boolean [] checkA = new boolean [N+1];
		boolean [] checkB = new boolean [N+1];
		
		queA.add(groupA.get(0));
		queB.add(groupB.get(0));
		checkA[groupA.get(0)] = true;
		checkB[groupB.get(0)] = true;
		
		while (!queA.isEmpty()) {
			int temp = queA.poll();
//			System.out.println(temp);
			for (int i : groupA) {
				if (connect[temp][i] && !checkA[i]) {
					queA.add(i);
					checkA[i] = true;
				}
			}
		}
		
		int sizeA = 0;
		int sumA = 0;
		for (boolean A : checkA) {
			if(A) sizeA++;
		}
		if (sizeA == groupA.size()) {
			for (int A : groupA) {
				sumA += area[A];
			}
//			System.out.println("\n"+"A 영역범위: "+ sizeA + " A 사람 합: " + sumA);
		}
		
		while (!queB.isEmpty()) {
			int temp = queB.poll();
//			System.out.println(temp);
			for (int i : groupB) {
				if (connect[temp][i] && !checkB[i]) {
					queB.add(i);
					checkB[i] = true;
				}
			}
		}
		
		int sizeB = 0;
		int sumB = 0;
		for (boolean B : checkB) {
			if(B) sizeB++;
		}
		if (sizeB == groupB.size()) {
			for (int B : groupB) {
				sumB += area[B];
			}
//			System.out.println("B 영역범위: "+ sizeB + " B 사람 합: " + sumB + "\n");
		}

		if (sizeA == groupA.size() && sizeB == groupB.size() && ans > Math.abs(sumA-sumB )) {
			ans = Math.abs(sumA-sumB);
		}
		
	}
}