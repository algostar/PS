package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem11052_JW2 {
	public static void main(String[] args) {
		new Problem11052_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] C = new int[N+1];
		int[] DT = new int[N+1];
		for (int i = 1; i <= N; i++) {
			C[i] = sc.nextInt();
			DT[i] = C[i];
		}
		
		for (int n = 1; n <= N; n++) {
			for (int m = 1; m < n; m++) {
				DT[n] = Math.max(DT[n], DT[n - m] + C[m]);
			}
		}
		System.out.println(DT[N]);
	}
}
