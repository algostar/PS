package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11053_JW {
	public static void main(String[] args) {
		new Problem11053_JW().nun();
	}

	int n;
	int[] A;
	int[] memo;
	private void nun() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		A = new int[n];
		memo = new int[n];
		Arrays.fill(memo, -1);
		for (int i = 0; i < n; i++) A[i] = sc.nextInt();
		
		int lis = 1;
		for (int i = 0; i < n; i++) lis = Math.max(lis, f(i));
		System.out.println(lis);
	}
	private int f(int ix) {
		if (memo[ix] != -1) return memo[ix];
		int lis = 1;
		
		for (int i = ix - 1; i >= 0; i--) {
			if (A[ix] > A[i]) {
				lis = Math.max(lis, f(i) + 1);
			}
		}
		
		return memo[ix] = lis;
	}
}
