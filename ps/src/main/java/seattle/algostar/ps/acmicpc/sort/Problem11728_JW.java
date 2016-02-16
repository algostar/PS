package seattle.algostar.ps.acmicpc.sort;

import java.io.*;
import java.util.*;

public class Problem11728_JW {
	public static void main(String[] args) throws IOException {
		new Problem11728_JW().solve();
	}

	private void solve() throws IOException {
		Reader.init(System.in);
		int n = Reader.nextInt();
		int m = Reader.nextInt();

		int[] A = new int[n + 1];
		int[] B = new int[m + 1];
		A[n] = Integer.MAX_VALUE;
		B[m] = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++)
			A[i] = Reader.nextInt();
		for (int i = 0; i < m; i++)
			B[i] = Reader.nextInt();

		Arrays.sort(A);
		Arrays.sort(B);

		int[] C = new int[n + m];
		int aix = 0;
		int bix = 0;
		PrintWriter out = new PrintWriter(System.out);
		for (int i = 0; i < n + m; i++) {
			if (A[aix] > B[bix]) {
				C[i] = B[bix];
				if (bix + 1 <= m)
					bix++;
			} else {
				C[i] = A[aix];
				if (aix + 1 <= n)
					aix++;
			}

			out.print(C[i]);
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
