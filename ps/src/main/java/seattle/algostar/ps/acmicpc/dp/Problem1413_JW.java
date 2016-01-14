package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1413_JW {
	public static void main(String[] args) {
		new Problem1413_JW().solve();
	}

	long[][] memo;

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		long fact = 1;
		for (int i = 2; i <= N; i++) fact *= i;
		memo = new long[N + 1][M + 1];
		for (long[] me : memo) Arrays.fill(me, -1);
		long cnt = f(N, M);
		long gcd = gcd(cnt, fact);
		System.out.println((cnt/gcd) + "/" + (fact/gcd));
	}

	private long f(int n, int m) {
		if (m < 0) return 0;
		if (n == 0) return 1;
		if (memo[n][m] != -1) return memo[n][m];

		return memo[n][m] = f(n - 1, m - 1) + (n - 1) * f(n - 1, m);
	}

	public long gcd(long cnt, long fact) {
		while (fact != 0) {
			long temp = cnt % fact;
			cnt = fact;
			fact = temp;
		}
		return Math.abs(cnt);
	}
}
