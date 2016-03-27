package seattle.algostar.ps.acmicpc.onedayonedp.d160323;

import java.util.Scanner;

public class Problem2688_JW {
	public static void main(String[] args) {
		new Problem2688_JW().solve();
		
	}

	private void solve() {
		int nn = 64;
		long[][] SS = new long[nn+1][10];
		long[] S = new long[nn+1];
		for (int a = 0; a <= 9; a++) {
			SS[1][a] = 1;
		}
		S[1] = 10;
		
		for (int n = 2; n <= nn; n++) {
			long sum = 0;
			for (int d = 0; d <= 9; d++) {
				for (int a = d; a >= 0; a--) {
					if (d-a >= 0) {
						SS[n][d] += SS[n-1][d-a];
					}
				}
				sum += SS[n][d];
			}
			S[n] = sum;
		}
		
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			int n = sc.nextInt();
			System.out.println(S[n]);
		}
	}
}
