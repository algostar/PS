package seattle.algostar.ps.acmicpc.onedayonedp.d160413;

import java.io.*;
import java.util.*;

public class Problem1727_JW3 {
	public static void main(String[] args) {
		new Problem1727_JW3().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		int[] man = new int[nn];
		int[] woman = new int[mm];
		for (int i = 0; i < nn; i++) man[i] = sc.nextInt();
		for (int j = 0; j < mm; j++) woman[j] = sc.nextInt();
		
		Arrays.sort(man);
		Arrays.sort(woman);
		
		long[][] F = new long[nn][mm];
				
		F[0][0] = Math.abs(man[0] - woman[0]);
		
		int pivot = nn - mm;
		for (int i = 0 ; i < nn; i++) {
			for (int j = 0; j < mm; j++) {
				if (i >= 1 && j >= 1) {
					F[i][j] = F[i-1][j-1] + Math.abs(man[i] - woman[j]);
				}
				if (pivot == 'm') {
					if (j >= 1 && j-1 >= i) {
						F[i][j] = Math.min(F[i][j], F[i][j-1]);
					}
				} else {
					if (i >= 1 && i-1 >= j) {
						F[i][j] = Math.min(F[i][j], F[i-1][j]);
					}
				}
			}
		}
		
		System.out.println(F[nn-1][mm-1]);
	}
}
