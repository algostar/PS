package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2293_JW {
	public static void main(String[] args) {
		new Problem2293_JW().run();
	}

	int n, k;
	int[] A;
	int[][] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		A = new int[n];
		memo = new int[n][k + 1];
		for (int[] m : memo) Arrays.fill(m, -1);
		for (int i = 0; i < n; i++) A[i] = sc.nextInt();
		
		int res = f(0, k);
		System.out.println(res);
	}
	private int f(int ix, int k) {
		if (k < 0) return 0;
		if (k == 0) return 1;
		if (memo[ix][k] != -1) return memo[ix][k];
		
		int cases = 0;
		for (int i = ix; i < n; i++) {
			cases += f(i, k - A[i]);
		}
		
		return memo[ix][k] = cases;
	}
}
