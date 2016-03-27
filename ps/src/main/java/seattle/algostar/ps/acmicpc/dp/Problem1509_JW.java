package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1509_JW {
	public static void main(String[] args) {
		new Problem1509_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] IN = sc.next().toCharArray();
		int nn = IN.length;
		
		boolean[][] isPalin = getIsPalin(IN, nn);
		
		int[] SS = new int[nn];
		Arrays.fill(SS, (int)1e9);
		SS[0] = 1;
		
		for (int i = 1; i < nn; i++) {
			if (isPalin[0][i]) {
				SS[i] = 1;
				continue;
			}
			
			for (int j = 1; i-j >= 0; j++) {
				int val = SS[i-j] + (isPalin[i-j+1][i] ? 1 : i - (i-j+1) + 1);
				SS[i] = Math.min(SS[i], val); 
			}
		}
		
		System.out.println(SS[nn-1]);
	}

	private boolean[][] getIsPalin(char[] IN, int nn) {
		boolean[][] isPalin = new boolean[nn][nn];
		for (int s = nn-1; s >= 0; s--) {
			isPalin[s][s] = true;
			for (int e = s + 1; e < nn; e++) {
				if (IN[s] == IN[e]) {
					isPalin[s][e] = (e - s == 1) ? true : isPalin[s + 1][e - 1];
				} else {
					isPalin[s][e] = false;
				}
			}
		}
		return isPalin;
	}
}
