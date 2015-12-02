package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem7579_JW {
	public static void main(String[] args) {
		new Problem7579_JW().run();
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
		for (int i = 0; i < n; i++) M[i] = sc.nextInt();
		for (int i = 0; i < n; i++) C[i] = sc.nextInt();
		
		memo = new int[n][m+1];
		for (int[] me : memo) Arrays.fill(me, -1);
		
		int ret = f(n-1, m);
		System.out.println(ret);
	}
	private int f(int i, int m) {
		if (m <= 0) return 0;
		if (i < 0) return 987654321;
		
		if (memo[i][m] != -1) return memo[i][m];
		
		int min = Math.min( f(i - 1, m - M[i]) + C[i], f(i - 1, m) );
		return memo[i][m] = min;
	}
}
