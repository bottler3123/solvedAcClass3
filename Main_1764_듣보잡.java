package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String [] dict = new String [N+M];
		for (int i = 0; i < N+M; i++) {
			dict[i] = in.readLine();
		}
		
		Arrays.sort(dict);
//		System.out.println(Arrays.deepToString(dict));
		
		int cnt = 0;
		for (int i = 0; i < N+M-1; i++) {
			if (dict[i].equals(dict[i+1])) {
				cnt++;
				sb.append(dict[i]).append("\n");
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}
