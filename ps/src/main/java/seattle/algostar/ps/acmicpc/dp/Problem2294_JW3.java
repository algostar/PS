package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2294_JW3 {
	public static void main(String[] args) {
		new Problem2294_JW3().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int kk = sc.nextInt();
		int[] C = new int[nn];
		for (int i = 0; i < nn; i++) C[i] = sc.nextInt();
		
		int[] DT = new int[kk+1];
		Arrays.fill(DT, (int)1e9);
		for (int i = 0; i < nn; i++) {
			if (kk >= C[i]) DT[C[i]] = 1;
		}
		
		for (int k = 0; k <= kk; k++) {
			for (int i = 0; i < nn; i++) {
				if (k >= C[i]) {
					DT[k] = Math.min(DT[k], DT[k - C[i]] + 1);
				}
			}
		}
			
		System.out.println(DT[kk] == (int)1e9 ? -1 : DT[kk]);
	}
}
