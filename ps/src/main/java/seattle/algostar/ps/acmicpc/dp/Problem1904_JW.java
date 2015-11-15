package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1904_JW {
	public static void main(String[] args) {
		new Problem1904_JW().run();
	}

	int N;
	int[] DP;
	private void run() {
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 DP = new int[N+1];
		 Arrays.fill(DP, -1);
		 System.out.println(f(0, 0));
	}
	private int f(int n, int ix) {
		if (n == N) return 1;
		if (n > N) return 0;
		if (DP[n] != -1) return DP[n];
		
		int cases = 0;
		
		cases += f(n+1, 1) % 15746;
		cases += f(n+2, 0) % 15746;
		
		return DP[n] = cases % 15746;
	}
}
