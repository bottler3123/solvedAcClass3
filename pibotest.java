package practice;
import java.util.Arrays;
import java.util.Scanner;

public class pibotest {

	static long[] calls1, calls2, memo;
	static long callCnt1, callCnt2;
	static int N;

	static long fibo1(int n) { // 메모 안하는 버전
		callCnt1++;
		calls1[n]++;

		if (n <= 1)
			return n;
		return fibo1(n - 1) + fibo1(n - 2);
	}

	static long fibo2(int n) { // 메모 안하는 버전
		callCnt2++;
		calls2[n]++;

		if (memo[n] == -1)
			memo[n] = fibo2(n-1) + fibo2(n-2);
		return memo[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		calls1 = new long[N + 1];
		calls2 = new long[N + 1];

		callCnt1 = callCnt2 = 0;

		memo = new long[N + 1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println("답 " + fibo1(N));
		System.out.println("시행횟수 " + callCnt1);
		for (int i = 0; i <= N ; i++) {
			System.out.println("fibo1("+i+") : "+calls1[i]);
		}
		
		System.out.println("===============================================");
		
		System.out.println(fibo2(N));
		System.out.println(callCnt2);
		for (int i = 0; i <= N ; i++) {
			System.out.println("fibo2("+i+") : "+calls2[i]);
		}
	}
}
