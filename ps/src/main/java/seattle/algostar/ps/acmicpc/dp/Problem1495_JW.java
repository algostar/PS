package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1495_JW {
	public static void main(String[] args) {
		new Problem1495_JW().solve();
	}	

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		
		boolean[][] DT = new boolean[M+1][N+1];
		DT[S][0] = true;
		for (int j = 0; j < N; j++) {
			for (int i = 0; i <= M; i++) {
				if (DT[i][j]) {
					if (i + A[j] <= M) DT[i + A[j]][j+1] = true;
					if (i - A[j] >= 0) DT[i - A[j]][j+1] = true;
				}
			}
		}
		
		int max = -1;
		for (int i = 0; i <= M; i++) {
			if (DT[i][N]) max = i;
		}
		System.out.println(max);
	}
}
