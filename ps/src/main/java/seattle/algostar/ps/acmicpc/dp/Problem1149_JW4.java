package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1149_JW4 {
	public static void main(String[] args) {
		new Problem1149_JW4().solve();
	}

	int R = 0, G = 1, B = 2;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] COST = new int[N + 1][3];
		
		for (int i = 0; i < N; i++) {
			COST[i][R] = sc.nextInt();
			COST[i][G] = sc.nextInt();
			COST[i][B] = sc.nextInt();
		}
		
		int[][] CACHE = new int[N + 1][3];
		
		for (int i = 0; i < N; i++) {
			CACHE[i+1][R] = Math.min(CACHE[i][G], CACHE[i][B]) + COST[i][R];
			CACHE[i+1][G] = Math.min(CACHE[i][R], CACHE[i][B]) + COST[i][G];
			CACHE[i+1][B] = Math.min(CACHE[i][R], CACHE[i][G]) + COST[i][B];
		}
		
		int min = Math.min(CACHE[N][R], CACHE[N][G]);
		min = Math.min(CACHE[N][B], min);
		System.out.println(min);
	}
}
