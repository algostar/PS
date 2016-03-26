package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1328_JW2 {
	public static void main(String[] args) {
		new Problem1328_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int ll = sc.nextInt();
		int rr = sc.nextInt();

		long[][][] DT = new long[nn + 1][ll + 1][rr + 1];

		DT[0][0][1] = 1;

		for (int n = 1; n <= nn; n++) {
			for (int l = 1; l <= ll; l++) {
				for (int r = 1; r <= rr; r++) {
					DT[n][l][r] += (DT[n - 1][l - 1][r] % 1000000007);
					DT[n][l][r] += (DT[n - 1][l][r - 1] % 1000000007);
					if (n >= 2) {
						DT[n][l][r] += ((n - 2) * DT[n - 1][l][r] % 1000000007);
					}
				}
			}
		}

		System.out.println(DT[nn][ll][rr] % 1000000007);

	}
}
