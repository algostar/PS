package seattle.algostar.ps.acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem5721_JW {
	public static void main(String[] args) throws IOException {
		new Problem5721_JW().solve();
	}	

	private void solve() throws IOException {
		Reader.init(System.in);
		
		while (true) {
			int vv = Reader.nextInt();
			int hh = Reader.nextInt();

			if (hh == 0 && vv == 0) break;
			
			int[] VDT = new int[vv+1];
			int[] HDT = new int[hh+1];
			
			for (int v = 1; v <= vv; v++) {
				Arrays.fill(HDT, 0);
				HDT[1] = Reader.nextInt();
				for (int h = 2; h <= hh; h++) {
					int val = Reader.nextInt();
					HDT[h] = HDT[h-1];
					HDT[h] = Math.max(HDT[h], HDT[h-2] + val);
				}
				
				if (v == 1) {
					VDT[v] = HDT[hh];
				} else {
					VDT[v] = VDT[v-1];
					VDT[v] = Math.max(VDT[v], VDT[v-2] + HDT[hh]);
				}
			}
			
			System.out.println(VDT[vv]);
		}
		
	}
	
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
}
