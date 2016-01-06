package seattle.algostar.ps.acmicpc.binarySearch;

import java.io.*;
import java.util.*;

public class Problem2776_JW {
	public static void main(String[] args) throws IOException {
		new Problem2776_JW().solve();
	}

	private void solve() throws IOException {
		Reader.init(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = Reader.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = Reader.nextInt();
			int[] A = new int[N];
			for (int i = 0; i < N; i++) A[i] = Reader.nextInt();
			Arrays.sort(A);
			int M = Reader.nextInt();
			for (int i = 0; i < M; i++) {
				int num = Reader.nextInt();
				int ret = Arrays.binarySearch(A, num);
				if (ret >= 0) out.println(1);
				else out.println(0);
			}
		}
		out.close();
	}
	
	static class Reader {  
	    static BufferedReader reader;
	    static StringTokenizer tokenizer;

	    static void init(InputStream input) {
	        reader = new BufferedReader(
	                     new InputStreamReader(input) );
	        tokenizer = new StringTokenizer("");
	    }

	    static String next() throws IOException {
	        while ( ! tokenizer.hasMoreTokens() ) {
	            tokenizer = new StringTokenizer(
	                   reader.readLine() );
	        }
	        return tokenizer.nextToken();
	    }

	    static int nextInt() throws IOException {
	        return Integer.parseInt( next() );
	    }
		
	    static double nextDouble() throws IOException {
	        return Double.parseDouble( next() );
	    }
	}
}
