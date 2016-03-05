package seattle.algostar.ps.acmicpc.onedayonedp.d160302;

import java.util.*;

public class Problem2602_JW2 {
	public static void main(String[] args) {
		new Problem2602_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] PAPER = sc.next().toCharArray();
		char[][] ROAD = new char[2][];
		ROAD[0] = sc.next().toCharArray();
		ROAD[1] = sc.next().toCharArray();
		
		int n = PAPER.length;
		int m = ROAD[0].length;
		int[][] DT = new int[n+1][2];

		DT[0][0] = 1;
		DT[0][1] = 1;
		
		for (int j = 0; j < m; j++) {
			for (int i = n-1; i >= 0; i--) {
				for (int t = 0; t < 2; t++) {
					if(PAPER[i] == ROAD[t][j]) {
						DT[i+1][t] += DT[i][1-t];
					}
				}
			}
		}
		
		System.out.println(DT[n][0] + DT[n][1]);
	}
}

