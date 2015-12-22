package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.*;

public class Problem2167_JW2 {
	public static void main(String[] args) throws IOException {
		new Problem2167_JW2().run();
	}		

	int n, m;
	int k;
	int[][] S;
	private void run() throws IOException {
		Reader.init(System.in);
		n = Reader.nextInt();
		m = Reader.nextInt();
		S = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int val = Reader.nextInt();
				S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + val;
			}
		}
		k = Reader.nextInt();
		
		for (int i = 0; i < k; i++) {
			int y1 = Reader.nextInt();
			int x1 = Reader.nextInt();
			int y2 = Reader.nextInt();
			int x2 = Reader.nextInt();
			
			int sum = S[y2][x2] - S[y2][x1-1] - S[y1-1][x2] + S[y1-1][x1-1];
			System.out.println(sum);
		}
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
