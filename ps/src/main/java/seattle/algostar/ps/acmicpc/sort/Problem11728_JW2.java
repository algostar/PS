package seattle.algostar.ps.acmicpc.sort;

import java.io.*;
import java.util.*;

public class Problem11728_JW2 {
	public static void main(String[] args) throws IOException {
		new Problem11728_JW2().solve();
	}

	private void solve() throws IOException {
		Reader.init(System.in);
		int n = Reader.nextInt();
		int m = Reader.nextInt();

		int[] A = new int[n + m];
		for (int i = 0; i < n + m; i++)
			A[i] = Reader.nextInt();

		Arrays.sort(A);

		PrintWriter out = new PrintWriter(System.out);
		for (int i = 0; i < n + m; i++) {
			out.print(A[i]);
			if (i < n + m - 1) out.print(' ');
		}
		out.flush();
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
