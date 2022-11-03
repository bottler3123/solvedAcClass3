import java.util.Scanner;

public class Main_11726_2xn타일링 {

	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] block = new int[1001];
        block[1] = 1;
        block[2] = 2;
        for (int i = 3; i <= N; i++)
            block[i] = (block[i - 1] + block[i - 2]) % 10007;

        System.out.println(block[N]);

	}

}
