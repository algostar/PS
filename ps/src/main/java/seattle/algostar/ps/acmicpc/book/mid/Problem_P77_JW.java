package seattle.algostar.ps.acmicpc.book.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem_P77_JW {
	public static void main(String[] args) {
		new Problem_P77_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int[][] map = new int[nn][nn];
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < nn; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		boolean[][] visit = new boolean[nn][nn];
		
		List<Integer> visitCnt = new ArrayList<Integer>();
		
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < nn; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					visitCnt.add( visitCount(i, j, map, visit) );
				}
			}
		}
		
		System.out.println(visitCnt.size());
		Collections.sort(visitCnt);
		for (int i = visitCnt.size() - 1; i >= 0; i--) {
			System.out.println(visitCnt.get(i));
		}
	}

	int[] dy = {0, 1, 0, -1};
	int[] dx = {1, 0, -1, 0};
	
	private int visitCount(int y, int x, int[][] map, boolean[][] visit) {
		int cnt = 1;
		visit[y][x] = true;
		
		for (int d = 0; d < dy.length; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (isInsideSize(ny, nx, map)) {
				if (map[ny][nx] == 1 && !visit[ny][nx]) {
					cnt += visitCount(ny, nx, map, visit);
				}
			}
		}
		
		return cnt;
	}

	private boolean isInsideSize(int ny, int nx, int[][] map) {
		int size = map.length;
		if (0 <= ny && ny <= size - 1 && 0 <= nx && nx <= size - 1) {
			return true;
		} else {
			return false;
		}
	}
}
