package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_2239_스도쿠 {

	static int[][] map;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String str = in.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		sdoku(0, 0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}

	}

	public static boolean xline(int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == num)
				return true;
		}
		return false;
	}

	public static boolean yline(int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num)
				return true;
		}
		return false;
	}

	public static boolean square(int x, int y, int num) {
		for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
			for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
				if (map[i][j] == num)
					return true;
			}
		}
		return false;
	}

	public static void sdoku(int x, int y) {
		if (x == 9 && y == 0) {
			flag = true;
			return;
		}
		if (map[x][y] != 0) {
			if (y + 1 < 9) {
				sdoku(x, y + 1);
			} else {
				sdoku(x + 1, 0);
			}
		} else {
			for (int num = 1; num < 10; num++) {
				if (xline(y, num))
					continue;
				if (yline(x, num))
					continue;
				if (square(x, y, num))
					continue;
				map[x][y] = num;
				if (y + 1 < 9) {
					sdoku(x, y + 1);
				} else {
					sdoku(x + 1, 0);
				}
				if (flag) return;
				map[x][y] = 0;
			}
		}
	}
}
