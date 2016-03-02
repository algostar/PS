package seattle.algostar.ps.acmicpc.math;

import java.util.Scanner;

public class Problem1004_JW {
	public static void main(String[] args) {
		new Problem1004_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int[][] point = new int[2][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					point[i][j] = sc.nextInt();
				}
			}
			
			int n = sc.nextInt();
			int totalCnt = 0;
			for (int i = 0; i < n; i++) {
				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int r = sc.nextInt();
				
				int cnt = 0;
				for (int p = 0; p < 2; p++) {
					int x = point[p][0];
					int y = point[p][1];
					
					if ( (x-cx)*(x-cx) + (y-cy)*(y-cy) < r*r ) {
						cnt++;
					}
				}
				
				if (cnt == 1) {
					totalCnt++;
				}
			}
			System.out.println(totalCnt);
		}
	}
}
