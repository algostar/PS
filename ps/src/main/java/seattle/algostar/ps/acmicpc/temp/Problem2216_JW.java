package seattle.algostar.ps.acmicpc.temp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2216_JW {
	public static void main(String[] args) {
		new Problem2216_JW().run();
	}

	int A, B, C;
	String a, b;
	int[][] memo;
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		a = sc.next();
		b = sc.next();
		memo = new int[a.length()][b.length()];
		for (int[] m : memo) Arrays.fill(m, Integer.MIN_VALUE);
		
		int sum = f(a.length()-1, b.length()-1);
		System.out.println(sum);
	}
	
	private int f(int i, int j) {
		if (i == -1 || j == -1) return B;
		if (i <= 0 && j <= 0) return 0;
		
		if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j];
		
		int sum = 0;
		int s1 = f(i-1, j-1) + (a.charAt(i) == b.charAt(j) ? A : C);
		int s2 = f(i-1, j) + B;
		int s3 = f(i, j-1) + B;
		
		sum += Math.max(s1, Math.max(s2, s3));
		return memo[i][j] = sum;
	}
}
