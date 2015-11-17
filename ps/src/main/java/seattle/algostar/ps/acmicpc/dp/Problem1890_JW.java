package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1890_JW {
	public static void main(String[] args) {
		new Problem1890_JW().run();
	}

	int N;
	int[][] A;
	long[][] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N][N];
		memo = new long[N][N];
		for (long[] m : memo) Arrays.fill(m, -1);
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				A[y][x] = sc.nextInt();
			}
		}
		System.out.println(f(0, 0));
	}
	private long f(int y, int x) {
		if ( !(0 <= y && y < N && 0 <= x && x < N) ) return 0;
		if (y == N-1 && x == N-1) return 1;
		if (A[y][x] == 0) return 0;
		
		if (memo[y][x] != -1) return memo[y][x];
		
		
		long cases = 0;
		
		int ny = y + A[y][x];
		int nx = x + A[y][x];
		
		cases += f(ny, x);
		cases += f(y, nx);
		
		return  memo[y][x] = cases;
	}
}
