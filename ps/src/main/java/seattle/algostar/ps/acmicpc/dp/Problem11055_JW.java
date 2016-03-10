package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem11055_JW {
	public static void main(String[] args) {
		new Problem11055_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] DT = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			DT[i] = A[i];
		}

		int max = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] > A[j]) {
					DT[i] = Math.max(DT[i], DT[j] + A[i]);
				}
				max = Math.max(max, DT[i]);
			}
		}
		System.out.println(max);
	}
}
