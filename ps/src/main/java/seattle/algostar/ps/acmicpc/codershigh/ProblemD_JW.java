package seattle.algostar.ps.acmicpc.codershigh;

import java.util.Scanner;

public class ProblemD_JW {
	public static void main(String[] args) {
		new ProblemD_JW().solve();
	}

	
	private void solve() {
		Scanner sc = new Scanner(System.in);
		
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		int kk = sc.nextInt();
		
		char[][] map = new char[mm * 2 + 1][];

		for (int m = 0; m < mm*2+1; m++) {
			map[m] = sc.next().toCharArray();
		}
		
		int[][] mapCompact = new int[mm][nn];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				makeMap0(i, j, map, mapCompact, 1);
			}
		}
	}

	private void makeMap0(int i, int j, char[][] map, int[][] mapCompact, int num) {
		if (map[i][j] == 'B' && mapCompact[i/2][j/2] == 0) {
			mapCompact[i/2][j/2] = num;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = dx[d];
			int ny = dy[d];
			
			if (0 <= nx && nx < map[0].length && 0 <= ny && ny < map.length) {
				int sy = (i + ny)/2;
				int sx = (j + nx)/2;

				
				
				makeMap0(ny, nx, map, mapCompact, num);
			}
		}
		
	}
	
	int[] dx = {0, 0, 2, -2};
	int[] dy = {2, -2, 0, 0};
	
}
