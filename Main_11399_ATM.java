import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {

	static int N,ans;
	static int [] money;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		money = new int [N];
		boolean [] check = new boolean [N];
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(money);
		
//		ans = Integer.MAX_VALUE;
//		perm(check,0,0,0);
//		System.out.println(ans);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				ans += money[j];
			}
		}
		System.out.println(ans);
	}

//	private static void perm(boolean[] check, int depth, int time, int sum) {
//		if (depth == N) {
//			ans = Math.min(sum, ans);
//			return;
//		}
//		
//		for (int i = 0; i < N; i++) {
//			if (!check[i]) {
//				check[i] = true;
//				time += money[i];
//				perm(check, depth+1, time, sum+time);
//				time -= money[i];
//				check[i] = false;
//			}
//		}
//	}
}
