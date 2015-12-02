package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem7579_JW {
	public static void main(String[] args) {
		new Problem7579_JW().run();
	}

	int n, m;
	int[] M;
	int[] C;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		M = new int[n]; C = new int[n];
		int ret = f(n-1, m);
		System.out.println(ret);
	}
	private int f(int i, int m) {
		if (i < 0) {
			if (m <= 0) return 0;
			else return 10000000;
		}
		
		int min = Math.min( f(i - 1, m - M[i]) + C[i], f(i - 1, m) );
		return min;
	}
}
