package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2302_JW {
	public static void main(String[] args) {
		new Problem2302_JW().run();
	}

	int N, M;
	int[] P;
	int[] A;
	int[] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		A = new int[M+2];
		A[0] = 1;
		A[M+1] = N;
		for (int i = 1; i <= M; i++) {
			A[i] = sc.nextInt();
		}
		P = new int[M+1];
		
		for (int i = 0; i < M+1; i++) {
			if (i == 0 || i == M) {
				P[i] = A[i+1] - A[i];
				if (A.length == 2) P[i] += 1;
			} else {
				P[i] = A[i+1] - A[i] - 1;
			}
		}
		
		memo = new int[N + 1];
		Arrays.fill(memo, -1);
		
		int cases = 1;
		for (int i = 0; i < M+1; i++) {
			cases *= f(P[i]);
		}
		System.out.println(cases);
	}
	private int f(int left) {
		if (left == 0) return 1;
		if (left < 0) return 0;
		if (memo[left] != -1) return memo[left];
		
		int cases = 0;
		cases += f(left - 1);
		cases += f(left - 2);
		return memo[left] = cases;
	}
}
