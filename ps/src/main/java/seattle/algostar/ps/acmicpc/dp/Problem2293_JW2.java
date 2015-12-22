package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2293_JW2 {
	public static void main(String[] args) {
		new Problem2293_JW2().run();
	}

	int n, k;
	int[] A;
	int[][] DP;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		DP = new int[n][k+1];
		for (int t = 0; k - t*A[0] > 0; t++) {
			DP[0][t*A[0]] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int t = 0; k - t*A[i-1] > 0; t++) {
				DP[i][k] += DP[i-1][t];
			}
		}
		
	}
}
