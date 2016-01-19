package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1937_JW {
	public static void main(String[] args) {
		new Problem1937_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int maxLen = 0;
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = true;
				int len = f(i, j, map, visited);
				visited[i][j] = false;
				maxLen = Math.max(maxLen, len);
			}
		}
		System.out.println(maxLen);
	}

	private int f(int y, int x, int[][] map, boolean[][] visited) {
		int len = 1;
		
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < map.length && 0 <= ny && ny < map.length) {
				if (!visited[ny][nx] && map[y][x] < map[ny][nx]) {
					visited[ny][nx] = true;
					len = Math.max(len, f(ny, nx, map, visited) + 1);
					visited[ny][nx] = false;
				}
			}
		}
		
		return len;
	}
}
