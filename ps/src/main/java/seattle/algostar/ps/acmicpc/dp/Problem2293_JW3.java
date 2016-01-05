package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2293_JW3 {
	public static void main(String[] args) {
		new Problem2293_JW3().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		
		int[][] DT = new int[N][K+1];
		
		DT[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				if (i > 0) DT[i][j] += DT[i-1][j];
				if (j >= A[i]) DT[i][j] += DT[i][j - A[i]];
			}
		}
		System.out.println(DT[N-1][K]);
	}
}
