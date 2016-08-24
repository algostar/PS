package seattle.algostar.ps.acmicpc.onedayonedp.d160413;

import java.io.*;
import java.util.*;

public class Problem1727_JW2 {
	public static void main(String[] args) {
		new Problem1727_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int nn = sc.nextInt();
			int mm = sc.nextInt();
			int[] man = new int[nn+1];
			int[] woman = new int[mm+1];
			for (int i = 1; i <= nn; i++) man[i] = sc.nextInt();
			for (int j = 1; j <= mm; j++) woman[j] = sc.nextInt();
			
			Arrays.sort(man);
			Arrays.sort(woman);
			
			long[][] F = new long[nn+1][mm+1];
			for (int i = 1; i <= nn; i++) for (int j = 1; j <= mm; j++) F[i][j] = (long)1e3;
			
			F[0][0] = 0;
			F[1][1] = Math.abs(man[1] - woman[1]);
			char smaller = (nn > mm) ? 'w' : 'm';
			if (smaller == 'm') {
				for (int j = 1; j <= mm; j++) {
					F[1][j] = Math.min(F[1][j-1], Math.abs(man[1] - woman[j]));
				}
			} else {
				for (int i = 1; i <= nn; i++) {
					F[i][1] = Math.min(F[i][1], Math.abs(man[i] - woman[1]));
				}
			}
			for (int i = 2 ; i <= nn; i++) {
				for (int j = 2; j <= mm; j++) {
					F[i][j] = F[i-1][j-1] + Math.abs(man[i] - woman[j]);
					
					if (smaller == 'm') {
						F[i][j] = Math.min(F[i][j], F[i][j-1]);
					} else {
						F[i][j] = Math.min(F[i][j], F[i-1][j]);
					}
				}
			}
			System.out.println(Arrays.deepToString(F));
			System.out.println(F[nn][mm]);
		}
	}
}
