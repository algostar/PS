package seattle.algostar.ps.acmicpc.datastructure;

import java.io.*;
import java.util.*;

public class Problem13701_JW {
	public static void main(String[] args) throws IOException {
		new Problem13701_JW().solve();
	}

	private void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BitSet bs = new BitSet(33554433);
		while (st.hasMoreTokens()) {
			String t = st.nextToken();
			int n = Integer.parseInt(t);
			if (!bs.get(n)) {
				bw.write(t);
				bs.set(n);
				bw.write(" ");
			} 
		}
		bw.flush();
	}
}
