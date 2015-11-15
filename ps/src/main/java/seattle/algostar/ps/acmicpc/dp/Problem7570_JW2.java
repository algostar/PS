package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Problem7570_JW2 {
	public static void main(String[] args) throws Exception {
		new Problem7570_JW2().run();
	}

	int n;
	int[] C;
	private void run() throws Exception {
		Reader.init(System.in);
		n = Reader.nextInt();
		C = new int[n+1];
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int n = Reader.nextInt();
			int beforeNum = n - 1;
			C[n] = C[beforeNum] + 1;
			
			max = Math.max(max, C[n]);
		}
		System.out.println(n - max);
		
	}
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
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

