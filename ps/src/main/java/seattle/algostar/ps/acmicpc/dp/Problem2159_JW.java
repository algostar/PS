package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2159_JW {
	public static void main(String[] args) {
		new Problem2159_JW().solve();
	}

	int[] DX = {0, 1, -1, 0, 0};
	int[] DY = {0, 0, 0, 1, -1};
	
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		
		int[] TX = new int[nn+1];
		int[] TY = new int[nn+1];
		TX[0] = sx;
		TY[0] = sy;
		for (int i = 1; i <= nn; i++) {
			TX[i] = sc.nextInt();
			TY[i] = sc.nextInt();
		}
		
		long[][] SS = new long[nn+1][5];
		for (long[] S : SS) Arrays.fill(S, (long)1e18);
		SS[0][0] = 0;
		for (int i = 1; i <= nn; i++) {
			for (int curD = 0; curD < 5; curD++) {
				if (i == 1) {
					SS[1][curD] = getVal(1, TX, TY, curD, 0);
					continue;
				}
				for (int pastD = 0; pastD < 5; pastD++) {
					SS[i][curD] = Math.min(SS[i][curD], SS[i-1][pastD] + getVal(i, TX, TY, curD, pastD));
				}
			}
		}
		
		long min = (long)1e18;
		for (int d = 0; d < 5; d++) {
			min = Math.min(min, SS[nn][d]);
		}
		
		System.out.println(min);
	}

	private long getVal(int i, int[] TX, int[] TY, int curD, int pastD) {
		
		int px = TX[i-1] + DX[pastD];
		int cx = TX[i] + DX[curD];
		
		int py = TY[i-1] + DY[pastD];
		int cy = TY[i] + DY[curD];

		long costX = Math.abs(px - cx);
		long costY = Math.abs(py - cy); 
		return costX + costY;
	}
	
}
