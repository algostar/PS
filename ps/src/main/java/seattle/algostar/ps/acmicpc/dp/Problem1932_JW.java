package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1932_JW {
	public static void main(String[] args) {
		new Problem1932_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] A = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		int[][] DT = new int[n][n];
		DT[0][0] = A[0][0];
		for (int i = 1; i < n; i++) {
			DT[i][0] = DT[i-1][0] + A[i][0];
			DT[i][i] = DT[i-1][i-1] + A[i][i];
		}
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				DT[i][j] = Math.max(DT[i-1][j-1], DT[i-1][j]) + A[i][j];
			}
		}
		
		int max = 0;
		for (int j = 0; j < n; j++) {
			max = Math.max(DT[n-1][j], max);
		}
		System.out.println(max);
	}
}
