package seattle.algostar.ps.acmicpc.elementry.koi2016;

import java.util.Scanner;

public class Problem13301_JW {
	public static void main(String[] args) {
		new Problem13301_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] L = new long[81];
		L[0] = L[1] = 1;
		for (int i = 2; i < n; i++) {
			L[i] = L[i-1] + L[i-2];
		}
		long[] D = new long[81];
		D[0] = 4; D[1] = 6;
		for (int i = 2; i < n; i++) {
			D[i] = D[i-1] + (2*L[i]);
		}
		System.out.println(D[n-1]);
	}
}
