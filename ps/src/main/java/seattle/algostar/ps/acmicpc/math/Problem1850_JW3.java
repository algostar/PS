package seattle.algostar.ps.acmicpc.math;

import java.util.*;

public class Problem1850_JW3 {
	public static void main(String[] args) {
		new Problem1850_JW3().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		int len = (int) gcd(x, y);
		System.out.println(getNum(len));
	}

	private long getNum(int len) {
		int num = 1;
		for (int i = 1; i < len; i++) {
			num = (num * 10 + 1);
		} 
		return num;
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
