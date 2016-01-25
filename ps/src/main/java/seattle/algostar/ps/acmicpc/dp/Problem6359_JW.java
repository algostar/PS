package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem6359_JW {
	public static void main(String[] args) {
		new Problem6359_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] memo = new int[101];
		for (int n = 5; n <= 100; n++) {
			boolean[] A = new boolean[n+1];
			Arrays.fill(A, true);
			for (int i = 2; i <= n; i++) {
				for (int p = i; p <= n; p += i) {
					A[p] ^= true;
				}
			}
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (A[i]) cnt++;
			}
			memo[n] = cnt;
		}
		
		while (T-- > 0) {
			int n = sc.nextInt();
			System.out.println(memo[n]);
		}
	}
}
