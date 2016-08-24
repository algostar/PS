package seattle.algostar.ps.acmicpc.onedayonedp.d160413;

import java.io.*;
import java.util.*;

public class Problem1727_JW {
	public static void main(String[] args) {
		new Problem1727_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < 10; t++) {
			int nn = sc.nextInt();
			int mm = sc.nextInt();
			int[] man = new int[nn];
			int[] woman = new int[mm];
			for (int i = 0; i < nn; i++) man[i] = sc.nextInt();
			for (int j = 0; j < mm; j++) woman[j] = sc.nextInt();
			int cc = Math.min(nn, mm);
			
			Arrays.sort(man);
			Arrays.sort(woman);
			
			long[][][] F = new long[nn][mm][cc+1];
			for (long[][] f1 : F) for (long[] f2 : f1) Arrays.fill(f2, (long)1e18);
			
			F[0][0][0] = 0;
			F[0][0][1] = Math.abs(man[0] - woman[0]);
			
			for (int i = 0 ; i < nn; i++) {
				for (int j = 0; j < mm; j++) {
					for (int c = 0; c <= cc; c++) {
						if (i >= 1 && j >= 1 && c >= 1) {
							F[i][j][c] = F[i-1][j-1][c-1] + Math.abs(man[i] - woman[j]);
						}
						
						if (i >= 1) {
							F[i][j][c] = Math.min(F[i][j][c], F[i-1][j][c]);
						}
						if (j >= 1) {
							F[i][j][c] = Math.min(F[i][j][c], F[i][j-1][c]);
						}
					}
				}
			}
			System.out.println(F[nn-1][mm-1][cc]);
		}
		
	}
}
