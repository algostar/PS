package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1660_JW2 {
	public static void main(String[] args) {
		new Problem1660_JW2().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int s = 120;
		int[] T = new int[s];
		int[] A = new int[s];
		T[0] = 1; A[0] = 1;
		for (int i = 1; i < s ; i++) {
			T[i] = T[i-1] + (i+1);
			A[i] = A[i-1] + T[i];
		}

		int[] DT = new int[N+1];
		for (int n = 0; n <= N; n++) DT[n] = n;
		
		for (int i = 1; i < s; i++) {
			if (A[i] > N) break;
			for (int n = A[i]; n <= N; n++) {
				DT[n] = Math.min(DT[n], DT[n - A[i]] + 1);
			}
		}
		System.out.println(DT[N]);
	}
}
