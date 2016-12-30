package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2156_JW2 {
	public static void main(String[] args) {
		new Problem2156_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] V = new int[N+1];
		for (int i = 0; i < N; i++) V[i] = sc.nextInt();
		
		int[][] D = new int[N+1][3];
		D[0][1] = V[0];
		for (int i = 0; i < N; i++) {
			for (int c = 0; c < 3; c++) {
				// c : 안마신다
				D[i+1][c] = Math.max(D[i][c], D[i+1][c]);
				// c : 마신다
				if (c != 2) {
					D[i+1][c+1] = Math.max(D[i][c] + V[i+1], D[i+1][c+1]);
				}
			}
		}
		int res = 0;
		for (int c = 0; c < 3; c++) res = Math.max(res, D[N][c]);
		System.out.println(res);
	}
}
