package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2240_JW {
	public static void main(String[] args) {
		new Problem2240_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int W = sc.nextInt();
		int[] A = new int[T+1];
		for (int t = 1; t <= T; t++) A[t] = sc.nextInt();
		
		int[][][] DT = new int[W+1][3][T+1];
		
		// init
		for (int p = 1; p <= 2; p++) {
			for (int t = 1; t <= T; t++) {
				DT[0][p][t] = DT[0][p][t-1];
				if (A[t] == p) {
					DT[0][p][t]++;
				}
			}
		}
			
		for (int w = 1; w <= W; w++) {
			for (int p = 1; p <= 2; p++) {
				for (int t = 1; t <= T; t++) {
					DT[w][p][t] = Math.max(DT[w][p][t-1], Math.max(DT[w-1][p][t-1], DT[w-1][3-p][t-1])); 
					DT[w][p][t] += (A[t] == p ? 1 : 0);
				}
			}
		}
		
		System.out.println(Math.max(DT[W][1][T], DT[W][2][T]));
	}
}
