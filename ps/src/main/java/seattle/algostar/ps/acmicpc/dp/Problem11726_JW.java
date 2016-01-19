package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem11726_JW {
	public static void main(String[] args) {
		new Problem11726_JW().solve();
	}

	int[] memo;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		memo = new int[N+1];
		int cnt = f(N);
		System.out.println(cnt);
	}

	private int f(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (memo[n] != 0) return memo[n];
		
		int cnt = f(n - 1) + f(n - 2);
		if (cnt > 10007) cnt %= 10007;
		return memo[n] = cnt;
	}
}
