package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1904_JW2 {
	public static void main(String[] args) {
		new Problem1904_JW2().run();
	}

	int N;
	int[] DP;
	private void run() {
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 DP = new int[N+1];
		 DP[0] = 0; DP[1] = 1; DP[2] = 2;
		 for (int i = 3; i <= N; i++) {
			 DP[i] = DP[i-1] + DP[i-2];
			 DP[i] %= 15746;
		 }
		 System.out.println(DP[N]);
	}
}
