package seattle.algostar.ps.acmicpc.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1920_JW {
	public static void main(String[] args) throws IOException {
		new Problem1920_JW().solve();
	}

	private void solve() throws IOException {
		Reader.init(System.in);
		
		int N = Reader.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = Reader.nextInt();
		
		qsort(A, 0, A.length-1);
		
		int M = Reader.nextInt();
		for (int i = 0; i < M; i++) {
			int ret = binarySearch(A, Reader.nextInt());
			if (ret != -1) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
	
	private void qsort(int[] A, int s, int e) {
		if (s < e) {
			int p = s;
			int l = s + 1;
			int r = e;
			
			while (l <= r) {
				while (l <= e && A[l] < A[p]) l++;
				while (r >= s+1 && A[p] < A[r]) r--;
				if (l < r) swap(A, l, r);
			}
			swap(A, p, r);
			
			qsort(A, s, r-1);
			qsort(A, r+1, e);
		}
	}

	private void swap(int[] A, int l, int r) {
		int t = A[l];
		A[r] = t;
		A[l] = t;
	}

	private int binarySearch(int[] A, int k) {
		int s = 0;
		int e = A.length-1;
		
		while (s <= e) {
			
			int m = (s + e) / 2;
			
			if (A[m] == k) return m;
			
			if (k < A[m]) e = m - 1;
			else s = m + 1;
		}
		
		return -1;
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
