package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11048_JW {
	public static void main(String[] args) throws IOException {
		new Problem11048_JW().solve();
	}

	private void solve() throws IOException {
		Reader.init(System.in);
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		
		int[][] V = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int val = Reader.nextInt();
				V[i][j] = val;
			}
		}
		int[][] DT = new int[n+1][m+1];
		for (int j = 1; j <= m; j++) {
			for (int i = 1; i <= n; i++) {
				DT[i][j] = Math.max(DT[i-1][j], DT[i][j-1]);
				DT[i][j] = Math.max(DT[i][j], DT[i-1][j-1]);
				DT[i][j] += V[i][j];
			}
		}
		
		System.out.println(DT[n][m]);
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
