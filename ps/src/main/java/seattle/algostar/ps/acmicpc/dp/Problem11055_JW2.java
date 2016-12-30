package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem11055_JW2 {
	public static void main(String[] args) {
		new Problem11055_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] D = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			D[i] = A[i];
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (A[i] < A[j]) {
					D[j] = Math.max(D[j], D[i] + A[j]);
				}
			}
		}
		
		int max = 0;
		for (int d : D) max = Math.max(max, d);
		System.out.println(max);
	}
}
