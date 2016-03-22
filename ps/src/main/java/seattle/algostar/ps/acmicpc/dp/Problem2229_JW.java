package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2229_JW {
	public static void main(String[] args) {
		new Problem2229_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int[] in = new int[nn];
		for (int i = 0; i < nn; i++) in[i] = sc.nextInt();
		
		int[][][] minmax = getMinMax(in);
		
		int[] DT = new int[nn+1];
		for (int i = 0; i < nn; i++) {
			DT[i] = getCal(0, i, minmax);
			for (int j = 1; i - j >= 0; j++) {
				DT[i] = Math.max(DT[i], DT[i - j] + getCal(i-j+1, i, minmax));
			}
		}
		
		System.out.println(DT[nn-1]);
	}

	private int getCal(int s, int e, int[][][] minmax) {
		return minmax[1][s][e] - minmax[0][s][e];
	}

	private int[][][] getMinMax(int[] in) {
		int n = in.length;
		int[][][] minmax = new int[2][n][n];
		for (int s = 0; s < n; s++) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (int e = s; e < n; e++) {
				min = Math.min(min, in[e]);
				max = Math.max(max, in[e]);
				minmax[0][s][e] = min;
				minmax[1][s][e] = max;
			}
		}
		return minmax;
	}

}
