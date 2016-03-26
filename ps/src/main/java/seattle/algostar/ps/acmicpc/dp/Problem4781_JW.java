package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.*;

public class Problem4781_JW {
	public static void main(String[] args) throws IOException {
		new Problem4781_JW().solve();
	}

	private void solve() throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int nn = Integer.parseInt(st.nextToken());
			int mm = (int)(Double.parseDouble(st.nextToken()) * 100);
			
			if (nn == 0 && mm == 0) break;
			
			int[] M = new int[nn];
			int[] C = new int[nn];
			
			for (int i = 0; i < nn; i++) {
				st = new StringTokenizer(br.readLine());
				
				C[i] = Integer.parseInt(st.nextToken());
				M[i] = (int)(Double.parseDouble(st.nextToken()) * 100);
			}
			
			int[] DT = new int[mm+1];
			for (int m = 1; m <= mm; m++) {
				DT[m] = DT[m-1];
				for (int i = 0; i < nn; i++) {
					if (m - M[i] >= 0) {
						DT[m] = Math.max(DT[m], DT[m - M[i]] + C[i]);
					}
				}
			}
			System.out.println(DT[mm]);
		}
	}
}
