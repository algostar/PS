package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem11652_JW {
	public static void main(String[] args) throws IOException {
		new Problem11652_JW().run();
	}

	private void run() throws IOException {
		Reader.init(System.in);
		
		int n = Reader.nextInt();
		
		long maxNum = -1, maxCnt = -1;
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			long num = Reader.nextLong();
			if (map.containsKey(num)) {
				cnt = map.get(num) + 1;
				map.put(num, cnt);
			} else {
				map.put(num, cnt);
			}
			if (cnt > maxCnt) {
				maxNum = num;
				maxCnt = cnt;
			} else if (cnt == maxCnt && maxNum > num) {
				maxNum = num;
			}
		}
		System.out.println(maxNum);
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

	    static long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    
	    static int nextInt() throws IOException {
	        return Integer.parseInt( next() );
	    }
		
	    static double nextDouble() throws IOException {
	        return Double.parseDouble( next() );
	    }
	}
}
