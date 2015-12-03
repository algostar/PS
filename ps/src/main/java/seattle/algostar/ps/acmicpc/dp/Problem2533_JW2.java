package seattle.algostar.ps.acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2533_JW2 {
	public static void main(String[] args) throws IOException {
		new Problem2533_JW2().run();
	}

	int n;
	List<List<Integer>> tree;
	
	int eaN = 0;
	int eaY = 1;
	int[][] memo;
	private void run() throws IOException {
		Reader.init(System.in);
		
		int n = Reader.nextInt();
		
		tree = new ArrayList<List<Integer>>();
		
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		int cSum = 0;
		for (int i = 0; i < n-1; i++) {
			int u = Reader.nextInt();
			int v = Reader.nextInt();
			tree.get(u).add(v);
			cSum += v; 
		}
		
		memo = new int[n+1][2];
		for (int[] me : memo) Arrays.fill(me, -1);
		
		int root = (n*(n+1)/2) - cSum;
		int min = Math.min( f(root, eaY) + 1, f(root, eaN) );
		System.out.println(min);
		
		System.out.println(Arrays.deepToString(memo));
	}
	
	private int f(int node, int eaYN) {
		if (tree.get(node).size() == 0) {
			return 0;
		}
		
		if (memo[node][eaYN] != -1) return memo[node][eaYN];
		
		int min = Integer.MAX_VALUE;
		if (eaYN == eaY) {
			int eaYcnt = 0;
			int eaNcnt = 0;
			
			for (int cNode : tree.get(node)) {
				eaYcnt += f(cNode, eaY) + 1;
				eaNcnt += f(cNode, eaN);
			}
			min = Math.min(eaYcnt, eaNcnt);
		} else {
			int eaYcnt = 0;
			for (int cNode : tree.get(node)) {
				eaYcnt += f(cNode, eaY) + 1;
			}
			min = eaYcnt;
		}
		return memo[node][eaYN] = min;
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
