package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11052_JW {
	public static void main(String[] args) {
		new Problem11052_JW().solve();
	}

	int N;
	int[] P;
	int[] memo;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = new int[N+1];
		for (int i = 1; i <= N; i++) P[i] = sc.nextInt();
		
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		int max = f(N);
		System.out.println(max);
	}
	private int f(int n) {
		if (n == 0) return 0;
		if (memo[n] != -1) return memo[n];
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (n - i >= 0) {
				max = Math.max(max, f(n - i) + P[i]);
			}
		}
		return memo[n] = max;
	}
}
