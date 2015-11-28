package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2662_JW {
	public static void main(String[] args) {
		new Problem2662_JW().run();
	}
	
	int n;
	int[][] company;
	int[][] memo;
	int[][] path;
	private void run() {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		n = sc.nextInt();
		company = new int[money+1][n];
		memo = new int[money+1][n];
		path = new int[money+1][n];
		for (int[] me : memo) Arrays.fill(me, -1);
		for (int[] pa : path) Arrays.fill(pa, 0);
		for (int m = 1; m <= money; m++) {
			sc.next();
			for (int c = 0; c < n; c++) {
				int b = sc.nextInt();
				company[m][c] = b;
			}
		}
		
		int max = f(money, n-1);
		System.out.println(max);
		
		printPath(money, n-1);
	}
	private void printPath(int money, int i) {
		if (i < 0) return;
		int nm = path[money][i];
		int ni = i-1;
		printPath(nm, ni);
		System.out.print(money - nm + " ");
	}
	private int f(int money, int i) {
		if (money < 0 || i < 0) return 0;
		
		if (memo[money][i] != -1) return memo[money][i];
		
		int maxBenefit = 0;
		
		for (int m = 0; money - m >= 0; m++) {
			int benefit = f(money - m, i - 1) + company[m][i];
			if (benefit >= maxBenefit) {
				path[money][i] = (money - m);
			}
			maxBenefit = Math.max(maxBenefit, benefit);
		}
		
		return memo[money][i] = maxBenefit;
	}
}
