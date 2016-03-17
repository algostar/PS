package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2293_JW4 {
	public static void main(String[] args) {
		new Problem2293_JW4().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int kk = sc.nextInt();
		int[] C = new int[nn];
		for (int i = 0; i < nn; i++) C[i] = sc.nextInt();
		
		int[][] DT = new int[nn][kk+1];
		DT[0][0] = 1;
		for (int i = 0; i < nn; i++) {
			for (int k = 0; k <= kk; k++) {
				if (i >= 1)
					DT[i][k] = DT[i - 1][k];
				if (k >= C[i])
					DT[i][k] += DT[i][k - C[i]];
			}
		}
		System.out.println(DT[nn-1][kk]);
	}
}
