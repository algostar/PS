package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2193_JW {
	public static void main(String[] args) {
		new Problem2193_JW().run();
	}

	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] DP = new long[91];
		DP[1] = 1;
		DP[2] = 1;
		for (int i = 3; i <= n; i++) {
			DP[i] = DP[i-1] + DP[i-2];
		}
		System.out.println(DP[n]);
	}
}
