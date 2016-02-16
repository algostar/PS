package seattle.algostar.ps.acmicpc.dp;

import java.util.*;

public class Problem11060_JW {
	public static void main(String[] args) {
		new Problem11060_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();

		int[] DT = new int[N];
		Arrays.fill(DT, 987654321);
		DT[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int n = 1; n <= A[i]; n++) {
				int ni = i + n;
				if (ni < N) {
					DT[ni] = Math.min(DT[ni], DT[i] + 1);
				}
			}
		}
		if (DT[N-1] == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(DT[N-1]);
		}
	}
}
