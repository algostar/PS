package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2631_JW {
	public static void main(String[] args) {
		new Problem2631_JW().run();
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
		
		int lisCnt = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			lisCnt = Math.max(lisCnt, f(i));
		}
		System.out.println(N - lisCnt);
	}
	private int f(int ix) {
		if (memo[ix] != 0) return memo[ix];
		int lisCnt = 1;
		for (int i = ix + 1; i < N; i++) {
			if (A[ix] < A[i]) {
				lisCnt = Math.max(lisCnt, f(i) + 1); 
			}
		}
		return memo[ix] = lisCnt;
	}
	
}
