package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem10844_JW {
	public static void main(String[] args) {
		new Problem10844_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] DT = new long[12][3];
		
		for (int n = 2; n <= 10; n++) {
			DT[n][0] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int n = 1; n <= 10; n++) {
				DT[n][i%3] = (DT[n-1][(i-1)%3] + DT[n+1][(i-1)%3]);
				if (DT[n][i%3] > 1000000000) {
					DT[n][i%3] %= 1000000000;
				}
			}
		}
		
		long sum = 0;
		for (int n = 1; n <= 10; n++) {
			sum = (sum + DT[n][(N-1)%3]) % 1000000000;
		}
		System.out.println(sum);
	}
}
