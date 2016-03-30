package seattle.algostar.ps.acmicpc.algorithm;

import java.util.Scanner;

public class Combination {
	public static void main(String[] args) {
		new Combination().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int rr = sc.nextInt();
		
		int[][] SS = new int[nn+1][rr+1];
		for (int n = 1; n <= nn; n++) {
			SS[n][1] = n;
			for (int r = 2; r <= n && r <= rr; r++) {
				SS[n][r] = SS[n-1][r] + SS[n-1][r-1];
			}
		}
		System.out.println(SS[nn][rr]);
	}
}
