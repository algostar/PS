package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1463_JW {
	public static void main(String[] args) {
		new Problem1463_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] DT = new int[N+1];
		for (int n = 2; n <= N; n++) {
			int min = Integer.MAX_VALUE;
			if (n % 3 == 0) min = Math.min(min, DT[n/3]);
			if (n % 2 == 0) min = Math.min(min, DT[n/2]);
			min = Math.min(min, DT[n-1]);
			DT[n] = min + 1;
		}
		System.out.println(DT[N]);
	}
}
