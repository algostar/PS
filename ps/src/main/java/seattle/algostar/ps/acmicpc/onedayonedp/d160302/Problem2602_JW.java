package seattle.algostar.ps.acmicpc.onedayonedp.d160302;

import java.util.*;

public class Problem2602_JW {
	public static void main(String[] args) {
		new Problem2602_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] PAPER = sc.next().toCharArray();
		char[][] ROAD = new char[2][];
		ROAD[0] = sc.next().toCharArray();
		ROAD[1] = sc.next().toCharArray();
		
		int n = PAPER.length;
		int m = ROAD[0].length;
		int[][][] DT = new int[n+1][2][m+1];

		for (int j = 0; j < m; j++) {
			if (PAPER[0] == ROAD[0][j]) DT[0][0][j] = 1;
			if (PAPER[0] == ROAD[1][j]) DT[0][1][j] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int t = 0; t < 2; t++) {
					if(PAPER[i] == ROAD[t][j]) {
						for (int k = 0; k < j; k++) {
							DT[i][t][j] += DT[i-1][1-t][k];
						}
					}
				}
			}
		}
		
		int sum = 0;
		for (int j = 0; j < m; j++) {
			sum += DT[n-1][0][j] + DT[n-1][1][j];
		}
		System.out.println(sum);
	}
}

