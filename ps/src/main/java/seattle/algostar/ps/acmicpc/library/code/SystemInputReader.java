package seattle.algostar.ps.acmicpc.library.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SystemInputReader {
	public static void main(String[] args) throws IOException {
		// example
		Reader.init(System.in);
		int n = Reader.nextInt();
	}

	/**
	 * Scanner의 느린 성능을 BufferedReader + StringTokenizer로 극복함  
	 *
	 */
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
