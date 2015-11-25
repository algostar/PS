package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.*;

public class Problem1365_JW {
	public static void main(String[] args) throws IOException {
		new Problem1365_JW().run();
	}

	int n;
	int[] A;
	int[] DP;
	
	private void run() throws IOException {
		Reader.init(System.in);
		n = Reader.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = Reader.nextInt();
		
		DP = new int[n];
		Arrays.fill(DP, 1);
		
		int lis = 1;
		for (int i = 0; i < n; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (A[j] < A[i] && DP[i] <= DP[j]) {
					DP[i] = DP[j] + 1;
					lis = Math.max(lis, DP[i]);
				}
			}
		}
		System.out.println(n - lis);
	}

	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}

}
