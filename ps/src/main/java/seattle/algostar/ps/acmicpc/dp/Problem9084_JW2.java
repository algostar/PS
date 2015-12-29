package seattle.algostar.ps.acmicpc.dp;

import java.util.*;

public class Problem9084_JW2 {
	public static void main(String[] args) {
		new Problem9084_JW2().solve();
	}

	int N;
	int[] A;
	int M;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt();
			A = new int[N];
			for (int i = 0; i < N; i++) A[i] = sc.nextInt();
			M = sc.nextInt();
			
			int[][] DT = new int[M+1][N];
			for (int t = 0; M - t*A[0] >= 0; t++) DT[t*A[0]][0] = 1;
			for (int m = 0; m <= M; m++) {
				for (int ix = 1; ix < N; ix++) {
					for (int t = 0; m - t*A[ix] >= 0; t++) {
						DT[m][ix] += DT[m - t*A[ix]][ix-1];
					}
				}
			}
			
			System.out.println(DT[M][N-1]);
		}
	}
}
