package seattle.algostar.ps.acmicpc.onedayonedp.d160323;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1750_JW {
	public static void main(String[] args) {
		new Problem1750_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int[] in = new int[nn];
		for (int i = 0; i < nn; i++) {
			in[i] = sc.nextInt();
		}

		long[] SS = new long[nn];
		SS[0] = (in[0] == 1) ? 1 : 0;
		for (int i = 1; i < nn; i++) {
			int cnt = 0;
			for (int j = 0; j <= i - 1; j++) {
				int gcd = GCD(in[j], in[i]);
				if (gcd == 1)
					cnt++;
			}
			SS[i] = SS[i - 1] + cnt;
			if (cnt >= 1) {
				for (int r = 1; r <= i - 1; r++) {
					SS[i] += (COMBI(i - 1, r) % 10000003);
				}
			}

			SS[i] %= 10000003;
		}
		
		System.out.println(SS[nn - 1]);
	}

	private long COMBI(int n, int r) {
		if (r > n / 2)
			r = n - r;
		long ans = 1;
		int i;

		for (i = 1; i <= r; i++) {
			ans *= n - r + i;
			ans /= i;
		}

		return ans;
	}

	private int GCD(int a, int b) {
		while (b != 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}
}
