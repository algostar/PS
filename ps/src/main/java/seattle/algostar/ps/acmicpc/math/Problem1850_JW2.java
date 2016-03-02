package seattle.algostar.ps.acmicpc.math;

import java.util.*;

public class Problem1850_JW2 {
	public static void main(String[] args) {
		new Problem1850_JW2().solve();
	}

	String[] C;
	
	private void solve() {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		int len = (int) gcd(x, y);
		
		C = new String[len+1];
		String s = divdeCache(len);
		System.out.println(s);
	}
	
	private String divdeCache(int len) {
		if (C[len] != null) return C[len];
		if (len == 1) return "1";

		if (len % 2 == 0) {
			return divdeCache(len / 2) + divdeCache(len / 2);
		} else {
			return divdeCache(len / 2) + divdeCache(len / 2 + 1);
		}
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
