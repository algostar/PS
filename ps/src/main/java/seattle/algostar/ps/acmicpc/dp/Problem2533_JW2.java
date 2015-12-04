package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.*;

public class Problem2533_JW2 {
	public static void main(String[] args) throws IOException {
		new Problem2533_JW2().run();
	}

	int n;
	List<List<Integer>> tree;
	List<List<Integer>> dagTree;
	
	int eaN = 0;
	int eaY = 1;
	int[][] memo;
	boolean[] visited;
	
	private void run() throws IOException {
		Reader.init(System.in);
		
		int n = Reader.nextInt();
		
		tree = new ArrayList<List<Integer>>();
		dagTree = new ArrayList<List<Integer>>();
		visited = new boolean[n+1];
		
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Integer>());
			dagTree.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n-1; i++) {
			int u = Reader.nextInt();
			int v = Reader.nextInt();
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		
		int rootNode = 1;
		makeDagTree(rootNode);
		
		memo = new int[n+1][2];
		for (int[] me : memo) Arrays.fill(me, -1);
		
		int min = Math.min(f(rootNode, eaY), f(rootNode, eaN));
		System.out.println(min);
	}
	
	private void makeDagTree(int node) {
		visited[node] = true;
		
		for (int child : tree.get(node)) {
			if (!visited[child]) {
				dagTree.get(node).add(child);
				makeDagTree(child);
			}
		}
	}

	private int f(int node, int eaYN) {
		if (memo[node][eaYN] != -1) return memo[node][eaYN];
		
		if (dagTree.get(node).size() == 0) return eaYN;
		
		int min = 0;
		if (eaYN == eaY) {
			for (int cNode : dagTree.get(node)) {
				min += Math.min(f(cNode, eaY), f(cNode, eaN));
			}
			min += 1;
		} else {
			for (int cNode : dagTree.get(node)) {
				min += f(cNode, eaY);
			}
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
