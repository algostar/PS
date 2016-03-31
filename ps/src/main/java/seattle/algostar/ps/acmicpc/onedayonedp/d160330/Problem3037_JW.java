package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3037_JW {
	public static void main(String[] args) {
		new Problem3037_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int cc = sc.nextInt();
		
		long[][] SS = new long[nn+1][cc+1];
		SS[1][0] = 1;
		SS[1][1] = 0;
		for (int i = 2; i <= nn; i++) {
			for (int c = 0; c <= cc; c++) {
				SS[i][c] = SS[i-1][c];
				for (int k = 1; c - k >= 0; k++) {
					SS[i][c] += SS[i-1][c-k];
					SS[i][c] %= 1000000007;
				}
			}
		}
		System.out.println(SS[nn][cc] % 1000000007);
	}
}
