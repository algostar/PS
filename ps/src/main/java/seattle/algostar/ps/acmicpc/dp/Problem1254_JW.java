package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1254_JW {
	public static void main(String[] args) {
		new Problem1254_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toCharArray();
		int n = in.length;
		boolean[][] DT = new boolean[n][n];
		for (int s = n - 1; s >= 0; s--) {
			DT[s][s] = true;
			for (int e = s + 1; e <= n-1; e++) {
				if (in[s] == in[e]) {
					DT[s][e] = (e - s == 1) ? true : DT[s+1][e-1];
				} else {
					DT[s][e] = false;
				}
			}
		}
		
		int max = 0;
		int	minPalin = Integer.MAX_VALUE;
		for (int s = n-1; s >= 0; s--) {
			if (DT[s][n-1]) {
				max = Math.max(max, n - s);
				minPalin = Math.min(minPalin, max + (n - max)*2);
			}
		}
		
		System.out.println(minPalin);
	}
}
