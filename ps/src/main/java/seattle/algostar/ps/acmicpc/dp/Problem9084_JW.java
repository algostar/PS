package seattle.algostar.ps.acmicpc.dp;

import java.util.*;

public class Problem9084_JW {
	public static void main(String[] args) {
		new Problem9084_JW().solve();
	}

	int N;
	int[] A;
	int M;
	int[][] memo;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			N = sc.nextInt();
			A = new int[N];
			for (int i = 0; i < N; i++) A[i] = sc.nextInt();
			M = sc.nextInt();
			
			memo = new int[N][M+1];
			for (int[] me : memo) Arrays.fill(me, -1);
			int total = f(N-1, M);
			System.out.println(total);
		}
	}
	private int f(int ix, int m) {
		if (ix < 0 || m < 0) return 0;
		if (ix == 0) {
			if (m % A[ix] == 0) return 1;
			else return 0;
		}
		if (memo[ix][m] != -1) return memo[ix][m];
		
		int total = 0;
		
		for (int t = 0; m - t*A[ix] >= 0; t++) {
			total += f(ix-1, m - t*A[ix]);
		}
		
		return memo[ix][m] = total;
	}
}
