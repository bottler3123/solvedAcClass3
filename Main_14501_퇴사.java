package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

	static int[][] day;
	static int ans, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		day = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			day[i][0] = T;
			day[i][1] = P;
		}

		ans = 0;
		farewell(0, 0);

		System.out.println(ans);
	}

	private static void farewell(int num, int salary) {

		if (num >= N) {
//			System.out.println(num + "일차까지 번 돈 " + salary);
			ans = Math.max(ans, salary);
			return;
		}

		if (num + day[num][0] <= N) {
			farewell(num + day[num][0], salary + day[num][1]);
		}
		farewell(num + 1, salary);

	}

}
