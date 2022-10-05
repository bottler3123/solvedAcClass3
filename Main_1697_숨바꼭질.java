import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[100001];

		Queue<int[]> queue = new LinkedList<>();
		check[N] = true;
		int[] root = { N, 0 };
		queue.add(root);

		while (true) {
			int[] temp = queue.poll();
			int num = temp[0];
			int cnt = temp[1];
			if (num == K) {
				System.out.println(cnt);
				break;
			}
			if (num + 1 <= 100000 && !check[num + 1]) {
				check[num + 1] = true;
				int [] temp2 = {num+1,cnt+1};
				queue.add(temp2);
			}
			if (num - 1 >=0 && !check[num - 1]) {
				check[num - 1] = true;
				int [] temp2 = {num-1,cnt+1};
				queue.add(temp2);
			}
			if (num * 2 <= 100000 && !check[num * 2]) {
				check[num * 2] = true;
				int [] temp2 = {num*2,cnt+1};
				queue.add(temp2);
			}
		}

	}
}
