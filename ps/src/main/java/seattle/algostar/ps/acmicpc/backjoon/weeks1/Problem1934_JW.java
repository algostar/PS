package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem1934_JW {
	public static void main(String[] args) {
		new Problem1934_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int gcd = gcd(a, b);
			System.out.println(a*b/gcd);
		}
	}

	private int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a % b);
	}
}
