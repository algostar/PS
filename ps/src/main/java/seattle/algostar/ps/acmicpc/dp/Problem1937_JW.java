package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1937_JW {
	public static void main(String[] args) {
		new Problem1937_JW().solve();
	}
	
	int[][] map;
	int[][] DT;
	int N;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int maxLen = 0;
		DT = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxLen = Math.max(maxLen, f(i, j));
			}
		}
		System.out.println(maxLen);
	}
	private int f(int i, int j) {
		if (DT[i][j] != 0) return DT[i][j];
		
		int maxLen = 1;

		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		for (int d = 0; d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (map[i][j] < map[ny][nx]) {
					maxLen = Math.max(maxLen, f(ny, nx) + 1);
				}
			}
		}
		return DT[i][j] = maxLen;
	}
}
