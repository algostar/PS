package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1208_JW {
	public static void main(String[] args) {
		new Problem1208_JW().run();
	}

	int n, s;
	int[] A;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) A[i] = sc.nextInt();
		
		int r = f(s, n-1, 0l);
		System.out.println(r);
	}
	
	private int f(int s, int ix, long bit) {
		if (ix < 0) {
			if (s == 0 && bit != 0) return 1;
			else return 0;
		}
		int cases = 0;
		cases += f(s, ix - 1, bit);
		cases += f(s - A[ix], ix - 1, bit |= (1 << ix));
		return cases;
	}
}
