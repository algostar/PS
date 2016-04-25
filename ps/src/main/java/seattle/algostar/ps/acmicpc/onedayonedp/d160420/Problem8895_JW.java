package seattle.algostar.ps.acmicpc.onedayonedp.d160420;

import java.util.Arrays;
import java.util.Scanner;

public class Problem8895_JW {
	public static void main(String[] args) {
		new Problem8895_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			int nn = sc.nextInt();
			int ll = sc.nextInt();
			int rr = sc.nextInt();
			
			long[][][] F = new long[nn+1][ll+1][rr+1];
			
			F[1][1][1] = 1;
			
			for (int n = 2; n <= nn; n++) {
				for (int l = 1; l <= ll; l++) {
					for (int r = 1; r <= rr; r++) {
						F[n][l][r] += F[n-1][l-1][r];
						F[n][l][r] += F[n-1][l][r-1];
						F[n][l][r] += (F[n-1][l][r]) * (n-2);
					}
				}
			}
			System.out.println(F[nn][ll][rr]);
		}
	}
}
