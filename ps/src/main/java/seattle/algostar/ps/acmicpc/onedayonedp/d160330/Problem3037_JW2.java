package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3037_JW2 {
	public static void main(String[] args) {
		new Problem3037_JW2().solve();
	}

	long MOD = 1000000007; 
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int cc = sc.nextInt();

		long[][] SS = new long[nn + 1][cc + 2];
		SS[1][0] = 1l;
		SS[1][1] = 0l;
		for (int i = 2; i <= nn; i++) {
			for (int c = 0; c <= cc; c++) {
				SS[i][c] = SS[i - 1][c];
				if (c - 1 >= 0)
					SS[i][c] = (SS[i][c] + SS[i][c - 1]) % MOD;
				if (c - i >= 0) {
					SS[i][c] = (SS[i][c] - SS[i - 1][c - i] + MOD) % MOD;
				}
			}
		}
		System.out.println(SS[nn][cc]);
	}
}
