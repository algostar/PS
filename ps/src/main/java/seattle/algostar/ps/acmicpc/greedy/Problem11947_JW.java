package seattle.algostar.ps.acmicpc.greedy;

import java.util.Scanner;

public class Problem11947_JW {
	public static void main(String[] args) {
		new Problem11947_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		while (tt-- > 0) {
			String n = sc.next();
			int d = n.charAt(0) - '0';
			int len = n.length();
			
			long maxN = (long) (5 * Math.pow(10, len-1));
			if (d < 5) {
				maxN = Integer.parseInt(n);
			}
			System.out.println(maxN * f(maxN));
		}
	}

	private long f(long maxN) {
		String sn = maxN + "";
		String rn = "";
		for (int i = 0; i < sn.length(); i++) {
			rn += (9 - (sn.charAt(i) - '0'));
		}
		return Long.parseLong(rn);
	}
}
