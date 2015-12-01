package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1208_JW2 {
	public static void main(String[] args) {
		new Problem1208_JW2().run();
	}

	int n, s;
	int[] A;
	int[][] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		A = new int[n];
		memo = new int[s][n];
		for (int[] me : memo) Arrays.fill(me, -1);
		for (int i = 0; i < n; i++) A[i] = sc.nextInt();
		
		int r = f(s, n-1);
		if (s == 0) r--;
		System.out.println(r);
	}
	
	private int f(int s, int ix) {
		if (ix < 0) {
			if (s == 0) return 1;
			else return 0;
		}
		
		if (memo[s][ix] != -1) return memo[s][ix];
		
		int cases = 0;
		cases += f(s, ix - 1);
		cases += f(s - A[ix], ix - 1);
		return memo[s][ix] = cases;
	}
}
