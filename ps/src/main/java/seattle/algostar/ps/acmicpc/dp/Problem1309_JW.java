package seattle.algostar.ps.acmicpc.dp;

import java.util.*;

public class Problem1309_JW {
	public static void main(String[] args) {
		new Problem1309_JW().run();
	}

	int N;
	int[][] DP;
	int MOD = 9901;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DP = new int[3][3];
		Arrays.fill(DP[0], 1);
		for (int i = 1; i < N; i++) {
			DP[i%3][0] = (DP[(i-1)%3][0] + DP[(i-1)%3][1] + DP[(i-1)%3][2])%MOD;
			DP[i%3][1] = (DP[(i-1)%3][0] + DP[(i-1)%3][2])%MOD;
			DP[i%3][2] = (DP[(i-1)%3][0] + DP[(i-1)%3][1])%MOD;
		}
		
		int sum = 0;
		for (int i = 0; i < 3; i++) sum += DP[(N-1)%3][i];
		System.out.println(sum % MOD);
	}
}
