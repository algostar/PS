package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11053_JW {
	public static void main(String[] args) {
		new Problem11053_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		
		int max = 1;
		int[] DT = new int[N];
		Arrays.fill(DT, 1);
		for (int i = 0; i < N; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (A[j] < A[i]) {
					DT[i] = Math.max(DT[i], DT[j] + 1);
					max = Math.max(max, DT[i]);
				}
			}
		}
		System.out.println(max);
	}
}
