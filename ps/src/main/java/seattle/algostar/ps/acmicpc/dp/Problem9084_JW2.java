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
			for (int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			M = sc.nextInt();

			int[][] DT = new int[N][M + 1];
			for (int ix = 0; ix < N; ix++) {
				DT[ix][0] = 1;
				for (int m = A[ix]; m <= M; m++) {
					if (ix > 0) 
						DT[ix][m] += DT[ix-1][m];
					DT[ix][m] += DT[ix][m - A[ix]];
				}
			}

			System.out.println(DT[N - 1][M]);
		}
	}
}
