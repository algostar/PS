package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1309_JW2 {
	public static void main(String[] args) {
		new Problem1309_JW2().run();
	}

	int N;
	int[][] DP;
	int MOD = 9901;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DP = new int[N][3];
		DP[0][0] = DP[0][1] = DP[0][2] = 1;
		for (int i = 1; i < N; i++) {
			DP[i][0] = (DP[i-1][1] + DP[i-1][2]) % MOD;
			DP[i][1] = (DP[i-1][0] + DP[i-1][2]) % MOD;
			DP[i][2] = (DP[i-1][0] + DP[i-1][1] + DP[i-1][2]) % MOD;
		}
		int cases = DP[N-1][0] + DP[N-1][1] + DP[N-1][2];
		System.out.println(cases % 9901);
	}
}
