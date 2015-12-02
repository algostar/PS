package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem7579_JW2 {
	public static void main(String[] args) {
		new Problem7579_JW2().run();
	}

	int n, m;
	int[] M;
	int[] C;
	int[][] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		M = new int[n]; C = new int[n];
		int totalCost = 0;
		for (int i = 0; i < n; i++) M[i] = sc.nextInt();
		for (int i = 0; i < n; i++) { C[i] = sc.nextInt(); totalCost += C[i]; }
		
		memo = new int[n][totalCost+1];
		for (int[] me : memo) Arrays.fill(me, -1);
		
		for (int c = 0; c <= totalCost; c++) {
			int ret = f(n-1, c);
			if (ret >= m) {
				System.out.println(c);
				break;
			}
		}
	}
	private int f(int i, int c) {
		if (i < 0) return 0;
		
		if (memo[i][c] != -1) return memo[i][c];
		
		int m1 = 0;
		if (c - C[i] >= 0) {
			m1 = f(i - 1, c - C[i]) + M[i];
		}
		int m2 = f(i - 1, c);
		int max = Math.max(m1, m2);
		return memo[i][c] = max;
	}
}
