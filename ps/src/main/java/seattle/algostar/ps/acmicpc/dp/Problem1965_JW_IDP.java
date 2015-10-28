package seattle.algostar.ps.acmicpc.dp;

import java.util.*;

public class Problem1965_JW_IDP {
	public static void main(String[] args) {
		new Problem1965_JW_IDP().run();
	}

	int N;
	int[] A;
	int[] DP;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N]; 
		DP = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();

		int lis = 1;
		Arrays.fill(DP, 1);
		for (int i = 0; i < N; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (A[j] < A[i] && DP[j] >= DP[i]) {
					DP[i] = DP[j] + 1;
					lis = Math.max(lis, DP[i]);
				}
			}
		}
		System.out.println(lis);
	}
}
