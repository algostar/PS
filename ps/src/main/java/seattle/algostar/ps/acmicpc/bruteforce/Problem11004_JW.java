package seattle.algostar.ps.acmicpc.bruteforce;

import java.io.*;
import java.util.*;

public class Problem11004_JW {
	public static void main(String[] args) throws IOException {
		new Problem11004_JW().run();
	}

	private void run() throws IOException {
		Reader.init(System.in);
		int n = Reader.nextInt();
		int k = Reader.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Reader.nextInt();
		}
		Arrays.sort(A);
		System.out.println(A[k - 1]);
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
