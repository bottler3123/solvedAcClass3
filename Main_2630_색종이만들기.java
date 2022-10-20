package solvedac_class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {

	static int[][] map;
	static int blue, white, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cuting(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void cuting(int x, int y, int N) {

		int color = map[x][y];
		boolean check = true;
		for (int i = x; i < N; i++) {
			for (int j = y; j < N; j++) {
				if (map[i][j] != color)
					check = false;
			}
		}

		if (check) {
			if (color == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}
		cuting(x, y, N / 2);
		cuting(x, y + N / 2, N / 2);
		cuting(x + N / 2, y, N / 2);
		cuting(x + N / 2, y + N / 2, N / 2);

	}
}
