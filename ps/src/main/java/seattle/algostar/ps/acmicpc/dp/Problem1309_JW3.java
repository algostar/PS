package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1309_JW3 {
	public static void main(String[] args) {
		new Problem1309_JW3().run();
	}

	int N;
	int MOD = 9901;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][][] DT = new int[N][2][2];
		DT[0][1][0] = 1;
		DT[0][1][1] = 2;
		
		for (int i = 1; i < N; i++) {
			DT[i][0][0] = DT[i-1][1][0];
			DT[i][0][1] = (DT[i-1][1][0] + DT[i-1][1][1]) % MOD;
			DT[i][1][0] = DT[i][0][1];
			DT[i][1][1] = (DT[i][0][0] + DT[i][0][1]) % MOD;
		}
		int sum = DT[N-1][1][0] + DT[N-1][1][1];
		System.out.println(sum % MOD);
	}
}
