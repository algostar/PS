package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1149_JW {
	public static void main(String[] args) {
		new Problem1149_JW().run();
	}

	int N;
	int[][] C;
	int R = 0, G = 1, B = 2;
	int[][] memo;
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = new int[N][3];
		memo = new int[N][3];
		for (int[] m : memo) Arrays.fill(m, Integer.MAX_VALUE);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				C[i][j] = sc.nextInt();
			}
		}
		
		int sum = Integer.MAX_VALUE;
		for (int c = 0; c < 3; c++) {
			sum = Math.min(sum, f(N-1, c));
		}
		System.out.println(sum);
	}
	private int f(int i, int color) {
		if (i < 0) return 0;
		if (memo[i][color] != Integer.MAX_VALUE) return memo[i][color];
		
		int sum = Integer.MAX_VALUE;
		for (int c = 0; c < 3; c++) {
			if (c != color) {
				sum = Math.min(sum, f(i-1, c) + C[i][color]);
			}
		}
		
		return memo[i][color] = sum;
	}
}
