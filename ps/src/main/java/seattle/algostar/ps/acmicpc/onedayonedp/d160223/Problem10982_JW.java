package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.util.Scanner;

public class Problem10982_JW {
	public static void main(String[] args) {
		new Problem10982_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int[] O1 = new int[N+2];
			int[] O2 = new int[N+2];
			for (int i = 1; i <= N; i++) {
				O1[i] = sc.nextInt();
				O2[i] = sc.nextInt();
			}
			
			int[][] C = new int[N+2][N+2];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;
					
					int prev = Math.min(i, j) - 1;
					C[i][j] = C[prev][j] + O1[prev];
					C[i][j] = Math.max(C[i][j], C[i][prev] + O2[prev]);
				}
			}
			
			System.out.println(Math.min(C[N][N-1], C[N-1][N]));
		}
		
	}
}
