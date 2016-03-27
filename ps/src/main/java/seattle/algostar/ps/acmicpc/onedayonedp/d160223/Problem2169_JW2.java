package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2169_JW2 {
	public static void main(String[] args) {
		new Problem2169_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		int[][] MAP = new int[nn+2][mm+3];
		for (int i = 1; i <= nn; i++) {
			for (int j = 1; j <= mm; j++) {
				MAP[i][j] = sc.nextInt();
			}
		}
		
		int[][][] DT = new int[2][nn+2][mm+3];
		for (int i = 0; i < 2; i++) 
			for (int j = 0; j <= nn; j++)
				Arrays.fill(DT[i][j], (int) -1e9);
		
		DT[0][0][1] = 0;
		
		for (int y = 1; y <= nn; y++) {
			for (int x = 1; x <= mm; x++) {
				int up = Math.max(DT[0][y-1][x], DT[1][y-1][x]);
				DT[0][y][x] = Math.max(DT[0][y][x-1], up) + MAP[y][x];
			}
			
			for (int x = mm; x >= 1; x--) {
				int up = Math.max(DT[0][y-1][x], DT[1][y-1][x]);
				DT[1][y][x] = Math.max(DT[1][y][x+1], up) + MAP[y][x];
			}
		}
		
		System.out.println(Math.max(DT[0][nn][mm], DT[1][nn][mm]));
	}
}
