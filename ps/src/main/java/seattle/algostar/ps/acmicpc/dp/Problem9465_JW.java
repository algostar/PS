package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9465_JW {
	public static void main(String[] args) throws IOException {
		new Problem9465_JW().run();
	}

	private void run() throws IOException {
		Reader.init(System.in);
		
		int t = Reader.nextInt();
		while (t-- > 0) {
			int n = Reader.nextInt();
			int[][] A = new int[2][n+1];
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					A[i][j] = Reader.nextInt();
				}
			}
			
			int[][] DT = new int[2][3];
			DT[0][1] = A[0][1];
			DT[1][1] = A[1][1];
			for (int j = 2; j <= n; j++) {
				DT[0][j%3] = Math.max(DT[0][(j-2)%3], Math.max(DT[1][(j-1)%3], DT[1][(j-2)%3])) + A[0][j];
				DT[1][j%3] = Math.max(DT[1][(j-2)%3], Math.max(DT[0][(j-1)%3], DT[0][(j-2)%3])) + A[1][j];
			}
			System.out.println(Math.max(DT[0][n%3], DT[1][n%3]));
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
