package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2281_JW {
	public static void main(String[] args) {
		new Problem2281_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		int[] V = new int[nn];
		for (int i = 0; i < nn; i++) V[i] = sc.nextInt();
		
		int[][] SS = new int[nn][mm+1];
		
		for (int i = 0; i < nn; i++) {
			for (int x = 1; x <= mm; x++) {
				SS[i + 1][x + (1+V[i])] = (int)(SS[i][x] - Math.pow((mm-x), 2) + Math.pow((mm - (x+(1+V[i]))), 2));
				SS[i + 1][V[i]] = (int)(SS[i][x] + Math.pow((mm-V[i]), 2));
			}
		}
	}
	
	
}
