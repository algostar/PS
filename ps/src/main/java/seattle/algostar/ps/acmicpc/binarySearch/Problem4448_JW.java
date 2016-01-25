package seattle.algostar.ps.acmicpc.binarySearch;

import java.io.*;
import java.util.*;

public class Problem4448_JW {
	public static void main(String[] args) throws IOException {

		Reader.init(System.in);
		PrintWriter bw = new PrintWriter(System.out);
		
		int T = Reader.nextInt();
		for (int i = 0; i < T; i++) {
			Set<Integer> map = new HashSet<Integer>(1000000);
			int n1 = Reader.nextInt();
			for (int j = 0; j < n1; j++) {
				int a = Reader.nextInt();
				map.add(a);
			}

			int n2 = Reader.nextInt();
			for (int j = 0; j < n2; j++) {
				int b = Reader.nextInt();
				if (map.contains(b))
					bw.println(1);
				else
					bw.println(0);
			}
		}
		bw.flush();
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
