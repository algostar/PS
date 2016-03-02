package seattle.algostar.ps.acmicpc.math;

import java.util.*;

public class Problem1850_JW {
	public static void main(String[] args) {
		new Problem1850_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		int len = (int) gcd(x, y);
		char[] S = new char[len];
		Arrays.fill(S, '1');
		System.out.println(String.valueOf(S));
	}
	
	private long gcd(long x, long y) {
		while (y != 0) {
			long r = x % y;
			x = y;
			y = r;
		}
		return x;
	}
}
