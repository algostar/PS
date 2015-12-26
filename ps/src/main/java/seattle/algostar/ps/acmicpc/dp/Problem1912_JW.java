package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1912_JW {
	public static void main(String[] args) throws IOException {
		new Problem1912_JW().run();
	}

	private void run() throws IOException {
		Reader.init(System.in);
		
		int n = Reader.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) A[i] = Reader.nextInt();
		int[] DT = new int[n];
		int max = Integer.MIN_VALUE;
		DT[0] = A[0];
		for (int i = 1; i < n; i++) {
			DT[i] = Math.max(0, DT[i-1]) + A[i];
			max = Math.max(max, DT[i]);
		}
		System.out.println(Math.max(max, DT[0]));
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
