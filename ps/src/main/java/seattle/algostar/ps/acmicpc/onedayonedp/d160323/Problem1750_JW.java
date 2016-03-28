package seattle.algostar.ps.acmicpc.onedayonedp.d160323;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1750_JW {
	public static void main(String[] args) {
		new Problem1750_JW().solve();
	}

	long MOD = 10000003;
	
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int[] in = new int[nn];
		int max = 0;
		for (int i = 0; i < nn; i++) {
			in[i] = sc.nextInt();
			max = Math.max(max, in[i]);
		}

		long[][] SS = new long[nn][max+1];
		SS[0][in[0]] = 1;
		
		for (int i = 1; i < nn; i++) {
			SS[i][in[i]]++;
			for (int g = 1; g < max+1; g++) {
				SS[i][g] += SS[i-1][g];
				SS[i][g] %= MOD;
				if (SS[i-1][g] > 0) {
					int gcd = getGCD(in[i], g);
					SS[i][gcd] += SS[i-1][g];
					SS[i][g] %= MOD;
				}
			}
		}
		
		System.out.println(SS[nn-1][1] % MOD);
	}
	
	private int getGCD(int a, int b) {
		while (b != 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

}
