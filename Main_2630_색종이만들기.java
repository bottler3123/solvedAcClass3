package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {

	static int [][] map;
	static int blue, white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cuting(0,0,N);
		System.out.println(blue);
		System.out.println(white);
	}
	
	private static void cuting(int x, int y, int N) {
		
		boolean check = checking(x,y,N);
		
		if (check) {
			if (map[x][y] == 1) {
				white++;
			} else {
				blue++;
			}
		} else {
			cuting(x,y,N/2);
			cuting(x+N/2,y,N/2);
			cuting(x,y+N/2,N/2);
			cuting(x+N/2,y+N/2,N/2);
		}
		
	}

	private static boolean checking(int x, int y, int N) {
		
		int color = map[x][y];
		
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if (map[i][j] == color) {
					continue;
				} else {
					return false;
				}
			}	
		}
		
		return true;
	}
}
