package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11722_JW {
	public static void main(String[] args) {
		new Problem11722_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		int[] D = new int[N];
		Arrays.fill(D, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (A[i] > A[j]) {
					D[j] = Math.max(D[j], D[i] + 1);
				}
			}
		}
		
		int max = 0;
		for (int d : D) max = Math.max(max, d);
		System.out.println(max);
	}
}
