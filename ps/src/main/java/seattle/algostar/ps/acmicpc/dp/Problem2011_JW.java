package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2011_JW {
	public static void main(String[] args) {
		new Problem2011_JW().run();
	}

	int MOD = 1000000;
	String s;
	long[] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		memo = new long[s.length()+1];
		Arrays.fill(memo, -1);
		System.out.println(f(s.length()));
	}
	private long f(int ix) {
		if (ix < 0) return 0;
		if (ix == 0) return 1;
		if (memo[ix] != -1) return memo[ix];
		
		long cases = 0;
		if (ix - 2 >= 0) {
			String num = s.substring(ix-2, ix);
			int n = Integer.parseInt(num);
			if (10 <= n && n <= 26) {
				cases += f(ix-2) % MOD;
			}
		}
		if (ix - 1 >= 0) {
			String num = s.substring(ix-1, ix);
			int n = Integer.parseInt(num);
			if (1 <= n && n <= 9) {
				cases += f(ix-1) % MOD;
			}
		}
		return memo[ix] = (cases % MOD);
	}
}
