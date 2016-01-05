package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1562_JW2 {
	public static void main(String[] args) {
		new Problem1562_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][][] DT = new int[N+2][10][1 << 10];
		
		for (int n = 1; n < 10; n++) {
			DT[1][n][1 << n] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int n = 0; n < 10; n++) {
				for (int b = 0; b < (1 << 10); b++) {
					if (n - 1 >= 0) DT[i+1][n-1][b|1<<n-1] += DT[i][n][b];
					if (n + 1 < 10) DT[i+1][n+1][b|1<<n+1] += DT[i][n][b];
				}
			}
		}
		
		int sum = 0;
		for (int n = 0; n < 10; n++) sum += DT[N][n][(1 << 10) - 1];
		System.out.println(sum);
	}
}
