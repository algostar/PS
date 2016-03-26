package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1028_JW {
	public static void main(String[] args) {
		new Problem1028_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int rr = sc.nextInt();
		int cc = sc.nextInt();
		char[][] map = new char[rr][];
		for (int i = 0; i < rr; i++) map[i] = sc.next().toCharArray();
		
		int[][] HDT = new int[rr][cc];
		int[][] VDT = new int[rr][cc];
		for (int i = 0; i < rr; i++) {
			HDT[i][0] = (map[i][0] == '1') ? 1 : 0; 
			for (int j = 1; j < cc; j++) {
				HDT[i][j] = (map[i][j] == '1') ? HDT[i][j - 1] + 1 : 0;
			}
		}
		for (int j = 0; j < cc; j++) {
			VDT[0][j] = (map[0][j] == '1') ? 1 : 0;
			for (int i = 1; i < rr; i++) {
				VDT[i][j] = (map[i][j] == '1') ? VDT[i -1][j] + 1 : 0;
			}
		}
		
		int maxSize = 0;
		int[][] DT = new int[rr][cc];
		for (int i = 0; i < rr; i++) {
			for (int j = 0; j < cc; j++) {
				int maxLen = Math.min(HDT[i][j], VDT[i][j]);
				for (int k = maxLen; k >= 1; k--) {
					if (j-k+1 < 0 || i-k+1 < 0) continue;
					
					if (k <= HDT[i-k+1][j] && k <= VDT[i][j-k+1]) {
						maxSize = Math.max(maxSize, k);
						break;
					}
				}
			}
		}
		System.out.println(maxSize);
	}
}

