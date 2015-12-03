package seattle.algostar.ps.acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2533_JW {
	public static void main(String[] args) throws IOException {
		new Problem2533_JW().run();
	}

	int n;
	List<List<Integer>> tree;
	
	int eaN = 0;
	int eaY = 1;
	int[][] DP;
	private void run() throws IOException {
		Reader.init(System.in);
		
		int n = Reader.nextInt();
		
		tree = new ArrayList<List<Integer>>();
		
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n-1; i++) {
			int u = Reader.nextInt();
			int v = Reader.nextInt();
			tree.get(u).add(v);
		}
		
		DP = new int[n+1][2];
		DP[1][eaY] = 1;
		for (int i = 1; i <= n; i++) {
			for (int child : tree.get(i)) {
				DP[i][eaY] = Math.min(DP[child][eaY] + 1 , DP[child][eaN]);
				DP[i][eaN] = DP[child][eaN] + 1;
			}
		}
		int min = Math.min(DP[n][eaY], DP[n][eaN]);
		System.out.println(min);
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
