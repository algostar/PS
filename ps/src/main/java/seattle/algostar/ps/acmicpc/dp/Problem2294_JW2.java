package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2294_JW2 {
	public static void main(String[] args) {
		new Problem2294_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int kk = sc.nextInt();
		int[] C = new int[nn];
		for (int i = 0; i < nn; i++) C[i] = sc.nextInt();
		
		int[][] DT = new int[nn][kk+1];
		for (int i = 0; i < nn; i++) {
			Arrays.fill(DT[i], (int)1e9);
			if (C[i] <= kk) DT[0][C[i]] = 1; 
		}
		
		for (int i = 1; i < nn; i++) {
			for (int k = 0; k <= kk; k++) {
				for (int j = 0; j < nn; j++) {
					DT[i][k] = Math.min(DT[i-1][k], DT[i][k]);
					if (k - C[j] >= 0) {
						DT[i][k] = Math.min(DT[i][k - C[j]] + 1, DT[i][k]);
					}
				}
			}
		}
		System.out.println(DT[nn-1][kk] == (int)1e9 ? -1 : DT[nn-1][kk]);
	}
}
