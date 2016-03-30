package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem5557_JW {
	public static void main(String[] args) {
		new Problem5557_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int[] V = new int[nn];
		for (int i = 0; i < nn; i++) V[i] = sc.nextInt();
		
		long[][] SS = new long[nn][21];
		SS[0][V[0]] = 1;
		for (int i = 1; i < nn-1; i++) {
			for (int s = 0; s <= 20; s++) {
				if (s - V[i] >= 0) {
					SS[i][s] += SS[i-1][s - V[i]];
				}
				if (s + V[i] <= 20) {
					SS[i][s] += SS[i-1][s + V[i]];
				}
			}
		}
		System.out.println(SS[nn-2][V[nn-1]]);
	}
}
