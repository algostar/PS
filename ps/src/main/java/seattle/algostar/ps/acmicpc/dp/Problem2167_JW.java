package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.*;

public class Problem2167_JW {
	public static void main(String[] args) throws IOException {
		new Problem2167_JW().run();
	}		

	int n, m;
	int[][] A;
	int k;
	private void run() throws IOException {
		Reader.init(System.in);
		n = Reader.nextInt();
		m = Reader.nextInt();
		A = new int[n + 1][m + 1];
		int[][] S = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				A[i][j] = Reader.nextInt();
				S[i][j] += A[i][j] + S[i][j-1];
			}
		}
		k = Reader.nextInt();
		
		for (int i = 0; i < k; i++) {
			int y1 = Reader.nextInt();
			int x1 = Reader.nextInt();
			int y2 = Reader.nextInt();
			int x2 = Reader.nextInt();
			
			int sum = 0;
			for (int ix = y1; ix <= y2; ix++) {
				sum += (S[ix][x2] - S[ix][x1-1]);
			}
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
