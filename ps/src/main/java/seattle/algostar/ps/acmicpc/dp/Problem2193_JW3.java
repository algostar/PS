package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2193_JW3 {
	public static void main(String[] args) {
		new Problem2193_JW3().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[][] cache = new long[N+2][2];
		
		cache[1][0] = 0;
		cache[1][1] = 1;
		for (int i = 1; i <= N; i++) {
			cache[i+1][0] = cache[i][0] + cache[i][1];
			cache[i+1][1] = cache[i][0];
		}
		System.out.println(cache[N][0] + cache[N][1]);
	}
}
