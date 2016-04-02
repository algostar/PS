package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Scanner;

public class Problem1949_JW {
	public static void main(String[] args) {
		new Problem1949_JW().solve();
	}

	int[] V;
	boolean[][] map;
	long[][] memo;
	
	private void solve() {
		Scanner sc = new Scanner(System.in);
		
		int nn = sc.nextInt();
		V = new int[nn+1];
		for (int i = 1; i <= nn; i++) V[i] = sc.nextInt();
		map = new boolean[nn+1][nn+1];
		
		for (int i = 0; i < nn-1; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			map[Math.min(n1,n2)][Math.max(n1,n2)] = true;
		}
		
		memo = new long[nn+1][2];
		System.out.println(Math.max(getMax(1, 1), getMax(1, 0)));
	}

	private long getMax(int i, int use) {
		if (memo[i][use] != 0) return memo[i][use];
		int max = (use == 1) ? V[i] : 0;
		for (int j = 1; j < map.length; j++) {
			if (i != j && map[i][j]) {
				if (use == 1) {
					max += getMax(j, 0);
				} else {
					max += Math.max(getMax(j, 0), getMax(j, 1));
				}
			}
		}
		return memo[i][use] = max;
	}
}
