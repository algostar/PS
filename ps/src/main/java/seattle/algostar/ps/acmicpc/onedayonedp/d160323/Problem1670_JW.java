package seattle.algostar.ps.acmicpc.onedayonedp.d160323;

import java.util.Scanner;

public class Problem1670_JW {
	public static void main(String[] args) {
		new Problem1670_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		long[] SS = new long[nn+1];
		SS[0] = 1;
		SS[2] = 1;
		for (int i = 4; i <= nn; i+=2) {
			for (int a = 2; a <= i - 2; a+=2) {
				SS[i] += (SS[a] * SS[i-a-2]);
				SS[i] %= 987654321;
			}
			SS[i] += SS[i-2];
			SS[i] %= 987654321;
		}
		System.out.println(SS[nn]);
	}
}
