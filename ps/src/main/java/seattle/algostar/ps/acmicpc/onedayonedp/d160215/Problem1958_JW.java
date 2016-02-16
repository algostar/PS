package seattle.algostar.ps.acmicpc.onedayonedp.d160215;

import java.util.Scanner;

public class Problem1958_JW {
	public static void main(String[] args) {
		new Problem1958_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] s1 = sc.next().toCharArray();
		char[] s2 = sc.next().toCharArray();
		char[] s3 = sc.next().toCharArray();
		
		int[][][] DP = new int[s1.length+1][s2.length+1][s3.length+1];
		
		int max = 0;
		for (int i = 1; i <= s1.length; i++) {
			for (int j = 1; j <= s2.length; j++) {
				for (int k = 1; k <= s3.length; k++) {
					if (s1[i-1] == s2[j-1] && s2[j-1] == s3[k-1]) {
						DP[i][j][k] = DP[i-1][j-1][k-1] + 1;
					} else {
						DP[i][j][k] = Math.max(DP[i-1][j][k], DP[i][j-1][k]);
						DP[i][j][k] = Math.max(DP[i][j][k], DP[i][j][k-1]);
					}
					max = Math.max(max, DP[i][j][k]);
				}
			}
		}
		System.out.println(max);
	}
}
