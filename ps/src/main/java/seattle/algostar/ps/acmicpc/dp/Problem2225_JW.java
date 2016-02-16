package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2225_JW {
	public static void main(String[] args) {
		new Problem2225_JW().solve();
	}

	int N;
	int[][] memo;
	
	private void solve() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();
		
		memo = new int[K+1][N+1];
		for(int[] me : memo) Arrays.fill(me, -1);
		
		int total = f(K, N);
		System.out.println(total);
	}

	private int f(int k, int n) {
		if (k == 0 && n == 0) return 1;
		if (k == 0 && n > 0) return 0;
		if (memo[k][n] != -1) return memo[k][n];
		
		int cases = 0;
		for (int i = 0; i <= N; i++) {
			if (n - i > 0) {
				cases += f(k - 1, n - i);
			} else if (n - i == 0) {
				cases++;
			}
			
			if (cases > 1000000000) {
				cases %= 1000000000;
			}
		}
		return memo[k][n] = cases;
	}
}
