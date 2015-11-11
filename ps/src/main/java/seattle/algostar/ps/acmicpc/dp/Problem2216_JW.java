package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2216_JW {
	public static void main(String[] args) {
		new Problem2216_JW().run();
	}

	int A,B,C;
	char[] a,b;
	int[][] memo;
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		a = sc.next().toCharArray(); b = sc.next().toCharArray();
		
		memo = new int[a.length][b.length];
		for (int[] m : memo) Arrays.fill(m, Integer.MIN_VALUE);
		int sum = f(a.length-1, b.length-1);
		System.out.println(sum);
	}
	
	private int f(int i, int j) {
		if (i < 0 && j < 0) return 0;
		if (i < 0) return (j+1) * B;
		if (j < 0) return (i+1) * B;
		if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j];

		int sum = 0;
		
		int s1 = f(i-1, j-1) + (a[i] == b[j] ? A : C);
		int s2 = f(i-1, j) + B;
		int s3 = f(i, j-1) + B;
		
		sum = Math.max(s1, Math.max(s2, s3));
		
		return memo[i][j] = sum;
	}
}
