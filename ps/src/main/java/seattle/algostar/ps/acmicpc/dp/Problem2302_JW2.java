package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2302_JW2 {
	public static void main(String[] args) {
		new Problem2302_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N+1];
		for (int i = 0; i < M; i++) A[sc.nextInt()] = -1;
		
		int[][] DT = new int[N+1][N+1];
		DT[1][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (A[i] != - 1 && i - j == -1) {
					DT[i][j] += 1;
				}
			}
		}
		System.out.println(DT[N][N]);
	}
}
