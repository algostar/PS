package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9251_JW {
	public static void main(String[] args) {
		new Problem9251_JW().run();
	}

	char[] s1, s2;
	int[][] memo;
	

	private void run() {
		Scanner sc = new Scanner(System.in);
		s1 = sc.next().toCharArray();
		s2 = sc.next().toCharArray();
		memo = new int[s1.length][s2.length];
		for (int[] m : memo)
			Arrays.fill(m, -1);

		System.out.println(f(s1.length - 1, s2.length - 1));
	}

	private int f(int i, int j) {
		if (i < 0 || j < 0)
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];

		int lcs = 0;
		if (s1[i] == s2[j]) {
			lcs += f(i - 1, j - 1) + 1;
		} else {
			lcs += Math.max(f(i - 1, j), f(i, j - 1));
		}

		return memo[i][j] = lcs;
	}
}
