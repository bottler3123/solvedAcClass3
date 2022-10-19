package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전0 {
	
	static int [] arr;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int [N];
		for (int i = N-1; i >= 0 ; i--) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		ans = Integer.MAX_VALUE;
		
		coin(N,K);
		System.out.println(ans);
	}

	private static void coin(int N, int K) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (K == 0) {
				break;
			}
			cnt += K / arr[i];
			K = K % arr[i];
		}
		ans = Math.min(cnt, ans);
	}

}
