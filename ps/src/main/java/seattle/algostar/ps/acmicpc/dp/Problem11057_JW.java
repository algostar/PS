package seattle.algostar.ps.acmicpc.dp;

import java.util.*;

public class Problem11057_JW {
	public static void main(String[] args) {
		new Problem11057_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] DT = new int[N+1][10];
		Arrays.fill(DT[0], 1);
		for (int n = 1; n <= N; n++) {
			for (int d = 0; d <= 9; d++) {
				for (int a = d; a >= 0; a--) {
					DT[n][d] += DT[n-1][a];
					DT[n][d] %= 10007;
				}
			}
		}
		System.out.println(DT[N][9]);
	}
}
