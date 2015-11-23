package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1562_JW {
	public static void main(String[] args) {
		new Problem1562_JW().run();
	}

	int n;
	int MOD = 1000000000;
	long[][][] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		memo = new long[n+1][10][1024];
		for (long[][] me : memo) for (long[] m : me) Arrays.fill(m, -1);
		
		long cases = 0;
		for (int a = 0; a <= 9; a++) {
			cases += f(n, a, 0);
		}
		System.out.println(cases % MOD);
	}
	private long f(int n, int a, int bit) {
		bit |= (1 << a);
		
		if (n == 1 && a != 0 && bit == 1023) {
			return 1;
		} else if (n == 1) {
			return 0;
		}
		
		if (memo[n][a][bit] != -1) return memo[n][a][bit];
		
		long cases = 0;
		if (a == 0) {
			cases = f(n - 1, a + 1, bit);
		} else if (0 < a && a < 9) {
			cases += f(n - 1, a + 1, bit);
			cases += f(n - 1, a - 1, bit);
		} else if (a == 9) {
			cases = f(n - 1, a - 1, bit);
		}
		
		return memo[n][a][bit] = (cases % MOD);
	}
}
