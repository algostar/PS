package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2579_JW {
	public static void main(String[] args) {
		new Problem2579_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n+1];
		int[][] DT = new int[n+1][2];
		
		for (int i = 1; i <= n; i++) A[i] = sc.nextInt();
		
		DT[1][0] = A[1];
		for (int i = 2; i <= n; i++) {
			DT[i][0] = Math.max(DT[i-2][0], DT[i-2][1]) + A[i];
			DT[i][1] = DT[i-1][0] + A[i];
		}
		System.out.println(Math.max(DT[n][0], DT[n][1]));
	}
}
