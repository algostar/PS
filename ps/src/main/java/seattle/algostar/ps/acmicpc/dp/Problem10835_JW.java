package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10835_JW {
	public static void main(String[] args) {
		new Problem10835_JW().run();
	}

	int n;
	int[] left;
	int[] right;
	int[][] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		left = new int[n]; right = new int[n];
		for (int i = 0; i < n; i++) left[i] = sc.nextInt();
		for (int i = 0; i < n; i++) right[i] = sc.nextInt();
		
		memo = new int[n][n];
		for (int[] me : memo) Arrays.fill(me, -1);
		int max = f(0, 0);
		System.out.println(max);
	}
	private int f(int i, int j) {
		if (i >= n || j >= n) return 0;
		if (memo[i][j] != -1) return memo[i][j];
		
		int max = 0;
		
		max = Math.max(max, f(i + 1, j));
		max = Math.max(max, f(i + 1, j + 1));
		if (left[i] > right[j]) {
			max = Math.max(max, f(i, j + 1) + right[j]);
		}
		
		return memo[i][j] = max;
	}
}
