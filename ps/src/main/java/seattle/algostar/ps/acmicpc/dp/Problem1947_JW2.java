package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1947_JW2 {
	public static void main(String[] args) {
		new Problem1947_JW2().run();
	}

	long[] DP;
	long MOD = 1000000000;
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		DP = new long[n+1];
		
		DP[0] = 0; DP[1] = 0; DP[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			DP[i] = (i - 1) * (DP[i-1] + DP[i-2]);
			if (DP[i] >= MOD) DP[i] %= MOD;
		}
		
		System.out.println(DP[n]);
	}
}
