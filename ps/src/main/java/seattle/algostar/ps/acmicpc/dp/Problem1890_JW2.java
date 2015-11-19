package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1890_JW2 {
	public static void main(String[] args) {
		new Problem1890_JW2().run();
	}

	int N;
	int[][] A;
	long[][] DP;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N][N];
		DP = new long[N][N];
		for (long[] m : DP) Arrays.fill(m, 0L);
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				A[y][x] = sc.nextInt();
			}
		}
		
		DP[0][0] = 1L;
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if ( !(y == N-1 && x == N-1) && DP[y][x] != 0) {
					int ny = y + A[y][x];
					int nx = x + A[y][x];
					if (ny < N) {
						DP[ny][x] += DP[y][x];
					}
					if (nx < N) {
						DP[y][nx] += DP[y][x];
					}
				}
			}
		}
		System.out.println(DP[N-1][N-1]);
		
	}
}
