package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {

	static int[] horseX = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] horseY = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int horseCnt;

	static int[] moveX = { 1, 0, -1, 0 };
	static int[] moveY = { 0, -1, 0, 1 };
	static int moveCnt;

	static boolean[][][] route;
	static int x, y;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[W][H];
		route = new boolean[W][H][K + 1];
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < H; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Moving(W, H, K, map);

		System.out.println(moveCnt);

	}

	static void Moving(int W, int H, int K, int[][] map) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0, 0 });

		while (!q.isEmpty()) {

			int temp[] = q.poll();
			x = temp[0];
			y = temp[1];
			horseCnt = temp[2];
			moveCnt = temp[3];

			// 도착하면 리턴
			if (x == W - 1 && y == H - 1) {
				return;
			}
			// 평범하게 이동
			for (int i = 0; i < 4; i++) {
				int newx = x + moveX[i];
				int newy = y + moveY[i];

				if (newx < 0 || newx >= W || newy < 0 || newy >= H) {
					continue;
				}
				if (route[newx][newy][horseCnt]) {
					continue;
				}
				if (map[newx][newy] == 0) {
					route[newx][newy][horseCnt] = true;
					q.offer(new int[] { newx, newy, horseCnt, moveCnt + 1 });
				}
			}
			// 횟수가 남았다면 말처럼 이동
			if (horseCnt < K) {
				for (int i = 0; i < 8; i++) {
					int newx = x + horseX[i];
					int newy = y + horseY[i];

					if (newx < 0 || newx >= W || newy < 0 || newy >= H) {
						continue;
					}
					if (route[newx][newy][horseCnt+1]) {
						continue;
					}
					if (map[newx][newy] == 0) {
						route[newx][newy][horseCnt + 1] = true;
						q.offer(new int[] { newx, newy, horseCnt + 1, moveCnt + 1 });
					}
				}
			}
		}

		moveCnt = -1;
	}
}
