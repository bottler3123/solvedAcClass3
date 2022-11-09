package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int [] student = new int [N];
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < N; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine()," ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			student[i] -= B;
			ans++;
			if (student[i] > 0) {
				if (student[i] % C != 0) {
					ans++;
				}
				ans += student[i] / C;
			}
		}
		
		System.out.println(ans);
	}
}
