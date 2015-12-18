package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem9613_JW {
	public static void main(String[] args) {
		new Problem9613_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for (int i = 0; i < n; i++) A[i] = sc.nextInt();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					sum += gcd(A[i], A[j]);
				}
			}
			System.out.println(sum);
		}
	}

	private int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
}
