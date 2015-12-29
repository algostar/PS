package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1958_JW {
	public static void main(String[] args) {
		new Problem1958_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] S1 = sc.next().toCharArray();
		char[] S2 = sc.next().toCharArray();
		char[] S3 = sc.next().toCharArray();

		int n1 = S1.length;
		int n2 = S2.length;
		int n3 = S3.length;
		int[][][] DT = new int[n1+1][n2+1][n3+1];
		
		int lcs = 0;
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				for (int k = 0; k < n3; k++) {
					if (S1[i] == S2[j] && S2[j] == S3[k]) {
						DT[i+1][j+1][k+1] = DT[i][j][k] + 1;
						lcs = Math.max(lcs, DT[i][j][k]+1);
					} else {
						int mx = Math.max(DT[i][j+1][k+1], DT[i+1][j][k+1]);
						DT[i+1][j+1][k+1] = Math.max(mx, DT[i+1][j+1][k]);
					}
				}
			}
		}
		System.out.println(lcs);
	}
}
