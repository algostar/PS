package seattle.algostar.ps.acmicpc.book.mid;

import java.util.Scanner;

public class Problem_P100_JW {
	public static void main(String[] args) {
		new Problem_P100_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int hh = sc.nextInt();
		int ww = sc.nextInt();
		
		char[][] map = new char[hh][ww];
		
		int sx = -1, sy = -1;
		for (int h = 0 ; h < hh; h++) {
			map[h] = sc.next().toCharArray();
			for (int w = 0; w < ww; w++) {
				if (map[h][w] == 'S') {
					sx = w;
					sy = h;
				}
				if (map[h][w] == 'G') {
					ex = w;
					ey = h;
				}
			}
		}
		boolean[][] visit = new boolean[hh][ww];
		getMinDist(sy, sx, 0, map, visit);
		System.out.println(minDist);
	}

	int ex = -1;
	int ey = -1;
	
	int[] dx = {0, 1, -1, 0};
	int[] dy = {1, 0, 0, -1};
	
	int minDist = Integer.MAX_VALUE;
	
	private void getMinDist(int y, int x, int step, char[][] map, boolean[][] visit) {
		if (y == ey && x == ex) {
			minDist = Math.min(step, minDist);
		}
		
		for (int d = 0; d < dx.length; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (isPossPos(nx, ny, map, visit)) {
				visit[ny][nx] = true;
				getMinDist(ny, nx, step + 1, map, visit);
				visit[ny][nx] = false;
			}
		}
	}

	private boolean isPossPos(int x, int y, char[][] map, boolean[][] visit) {
		boolean isInside = (0 <= x && x < map[0].length) && (0 <= y && y < map.length);
		
		if (isInside && map[y][x] != '#' && !visit[y][x]) {
			return true;
		} else {
			return false;
		}
	}
}
