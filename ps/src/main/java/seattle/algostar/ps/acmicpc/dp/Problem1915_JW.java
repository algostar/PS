package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1915_JW {
	public static void main(String[] args) {
		new Problem1915_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] A = new char[N][M];
		for (int i = 0; i < N; i++) {
			A[i] = sc.next().toCharArray();
		}
		
		int max = 0;
		int[][] DT = new int[N+1][M+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] == '1') {
					DT[i+1][j+1] = Math.min(DT[i][j], Math.min(DT[i+1][j], DT[i][j+1])) + 1;
					max = Math.max(DT[i+1][j+1], max);
				}
			}
		}
		System.out.println(max*max);
	}
}
