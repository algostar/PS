package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1463_JW3 {
	public static void main(String[] args) {
		new Problem1463_JW3().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1];
		Arrays.fill(D, (int)1e9);
		D[N] = 0;
		for (int i = N; i >= 1; i--) {
			if (i % 3 == 0) D[i/3] = Math.min(D[i/3], D[i] + 1);
			if (i % 2 == 0) D[i/2] = Math.min(D[i/2], D[i] + 1);
			D[i-1] = Math.min(D[i-1], D[i] + 1);
		}
		System.out.println(D[1]);
	}
}
