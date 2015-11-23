package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2294_JW {
	public static void main(String[] args) {
		new Problem2294_JW().run();
	}

	int n, k;
	int[] A;
	int[] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) A[i] = sc.nextInt();
		
		memo = new int[k+1];
		Arrays.fill(memo, -1);
		int r = f(k);
		r = r >= 987654321 ? -1 : r;
		System.out.println(r);
	}
	private int f(int k) {
		if (k == 0) return 0;
		if (k < 0) return 987654321;
		if (memo[k] != -1) return memo[k];
		
		int min = 987654321;
		for (int ix = 0; ix < n; ix++) {
			min = Math.min(min, f(k - A[ix]) + 1);
		}
		return memo[k] = min;
	}
}
