package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2666_JW {
	public static void main(String[] args) {
		new Problem2666_JW().run();
	}

	int n, si, sj, m;
	int[] A;
	
	boolean[][] visited;
	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		si = sc.nextInt();
		sj = sc.nextInt();
		m = sc.nextInt();
		A = new int[m];
		for (int i = 0; i < m; i++) A[i] = sc.nextInt();
		
		visited = new boolean[n][3000];
		int r = f(0, si, sj);
		System.out.println(r);
	}
	
	int[] di = {-1, 1, 0, 0};
	int[] dy = {0, 0, 1, -1};
	private int f(int ix, int i, int j) {
		if (ix == m) return 0;
		
		visited[ix][i*100 + j] = true;

		int min = 987654321;
		
		if (i == A[ix] || j == A[ix]) {
			ix++;
			min = f(ix, i, j);
		} else {
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dy[d];
				if (isPoss(ni, nj)) {
					if (!visited[ix][ni*100 + nj]) {
						min = Math.min(min, f(ix, ni, nj)) + 1;
					}
				}
			}
		}
		
		return min;
	}
	private boolean isPoss(int ni, int nj) {
		if (ni == nj) return false;
		if (1 <= ni && ni <= n && 1 <= nj && nj <= n) return true;
		return false;
	}
}
