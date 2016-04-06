package seattle.algostar.ps.acmicpc.onedayonedp.d160406;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10653_JW {
	public static void main(String[] args) {
		new Problem10653_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int kk = sc.nextInt();
		
		int[] X = new int[nn];
		int[] Y = new int[nn];
		for (int i = 0; i < nn; i++) {
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
		}
		
		int[][] F = new int[nn][kk+1];
		for(int[] f : F) Arrays.fill(f, (int)1e9);
		F[0][0] = 0;
		for (int i = 0; i < nn; i++) {
			for (int k = 0; k <= kk; k++) {
				for (int t = 1; k - t + 1 >= 0 && i - t >= 0; t++) {
					F[i][k] = Math.min(F[i][k], F[i - t][k - t + 1] + getDist(i - t, i, X, Y));
				}
			}
		}
		
		System.out.println(F[nn-1][kk]);
	}

	private int getDist(int from, int to, int[] x, int[] y) {
		return Math.abs(x[from] - x[to]) + Math.abs(y[from] - y[to]);
	}
}
