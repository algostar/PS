package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2193_JW2 {
	public static void main(String[] args) {
		new Problem2193_JW2().run();
	}
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] DP = new long[3];
		DP[0] = 0;
		DP[1] = 1;
		for (int i = 2; i <= n; i++) {
			DP[i%3] = DP[(i-1)%3] + DP[(i-2)%3];
		}
		System.out.println(DP[n%3]);
	}
}
