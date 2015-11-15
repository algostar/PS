package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem7570_JW {
	public static void main(String[] args) {
		new Problem7570_JW().run();
	}

	int n;
	int[] A;
	int[] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		A = new int[n+1];
		A[0] = -1;
		memo = new int[n+1];
		for (int i = 1; i <= n; i++) A[i] = sc.nextInt();
		
		System.out.println(n - (f(0) - 1));
	}
	private int f(int ix) {
		if (memo[ix] != 0) return memo[ix];
		
		int cnt = 1;
		for (int i = ix+1; i <= n; i++) {
			if (A[ix] < A[i]) {
				cnt = Math.max(cnt, f(i) + 1);
			}
		}
		return memo[ix] = cnt;
	}
}
