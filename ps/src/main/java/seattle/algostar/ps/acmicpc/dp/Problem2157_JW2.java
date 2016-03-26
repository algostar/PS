package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2157_JW2 {
	public static void main(String[] args) {
		new Problem2157_JW2().solve(); 
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		int kk = sc.nextInt();

		int[][] paths = new int[nn+1][nn+1];
		int[][] DT = new int[nn+1][mm+1];
		for (int i = 0; i <= nn; i++) {
			Arrays.fill(paths[i], Integer.MIN_VALUE);
			Arrays.fill(DT[i], Integer.MIN_VALUE);
		}
		
		for (int i = 0; i < kk; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
			paths[s][e] = Math.max(paths[s][e], v); 
		}
		
		DT[1][1] = 0;
		for (int i = 1; i <= nn; i++) {
			for (int t = 1; t < i; t++) {
				for (int m = 2; m <= mm; m++) {
					if (DT[i - t][m - 1] != Integer.MIN_VALUE && paths[i-t][i] != Integer.MIN_VALUE) {
						DT[i][m] = Math.max(DT[i][m], DT[i - t][m - 1] + paths[i - t][i] );
					}
				}
			}
		}
		
		int max = 0;
		for (int m = 1; m <= mm; m++) {
			max = Math.max(max, DT[nn][m]);
		}
		System.out.println(max);
	}
}
