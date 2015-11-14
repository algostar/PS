package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem9095_JW {
	public static void main(String[] args) {
		new Problem9095_JW().run();
	}

	int N;
	int[] DP;
	private void run() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		DP = new int[12];
		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		for (int i = 4; i < 12; i++) {
			DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
		}
		while (t-- > 0) {
			N = sc.nextInt();
			System.out.println(DP[N]);
		}
		
	}
}
