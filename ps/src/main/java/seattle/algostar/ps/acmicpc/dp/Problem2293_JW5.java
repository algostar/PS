package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2293_JW5 {
	public static void main(String[] args) {
		new Problem2293_JW5().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int kk = sc.nextInt();
		int[] C = new int[nn];
		for (int i = 0; i < nn; i++) C[i] = sc.nextInt();
		
		int[] DT = new int[kk+1];
		DT[0] = 1;
		for (int i = 0; i < nn; i++) {
			for (int k = 0; k <= kk; k++) {
				if (k >= C[i])
					DT[k] += DT[k - C[i]];
			}
		}
		System.out.println(DT[kk]);
	}
}
