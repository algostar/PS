package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2666_JW2 {
	public static void main(String[] args) {
		new Problem2666_JW2().solve();
	}

	int N, M;
	int[] A;
	int[][][] memo;
	boolean[][][] hit;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int o1 = sc.nextInt();
		int o2 = sc.nextInt();
		M = sc.nextInt();
		A = new int[M];
		for (int i = 0; i < M; i++) A[i] = sc.nextInt();
		memo = new int[M][N+1][N+1];
		hit = new boolean[M][N+1][N+1];
		int cnt = f(0, o1, o2);
		System.out.println(cnt);
	}

	private int f(int i, int o1, int o2) {
		if (i >= M) return 0;
		if (hit[i][o1][o2]) return memo[i][o1][o2];
		
		int c1 = f(i+1, A[i], o2) + Math.abs(A[i] - o1);
		int c2 = f(i+1, o1, A[i]) + Math.abs(A[i] - o2);
		hit[i][o1][o2] = true;
		return memo[i][o1][o2] = Math.min(c1, c2);
	}

}
