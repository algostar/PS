package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1965_JW {
	public static void main(String[] args) {
		new Problem1965_JW().run();
	}

	int N;
	int[] A;
	int[] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N]; 
		memo = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		
		int lis = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			lis = Math.max(lis, f(i));
		}
		System.out.println(lis);
	}
	private int f(int ix) {
		if (memo[ix] != 0) return memo[ix];
		int lis = 1;
		for (int i = ix+1; i < N; i++) {
			if (A[ix] < A[i]) {
				lis = Math.max(lis, f(i) + 1);
			}
		}
		return memo[ix] = lis;
	}
}
