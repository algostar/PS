package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2410_JW {
	public static void main(String[] args) {
		new Problem2410_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int lastExp = 1;
		int[] POW = new int[21];
		POW[0] = 1;
		for (int i = 1; i < 21; i++) {
			POW[i] = POW[i-1] * 2;
			if (POW[i] <= N) lastExp = i;
		}
		
		long[][] DT = new long[lastExp+1][N+1];
		Arrays.fill(DT[0], 1);
		for (int i = 1; i <= lastExp; i++) {
			for (int j = 0; j <= N; j++) {
				DT[i][j] = DT[i-1][j];
				int before = j - POW[i];
				if (before >= 0) {
					DT[i][j] += DT[i][before];
				}
				if (DT[i][j] > 1000000000) DT[i][j] %= 1000000000; 
			}
		}
		System.out.println(DT[lastExp][N]);
		
	}
}
