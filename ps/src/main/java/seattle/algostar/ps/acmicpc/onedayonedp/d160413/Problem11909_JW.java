package seattle.algostar.ps.acmicpc.onedayonedp.d160413;

import java.io.*;
import java.util.*;

public class Problem11909_JW {
	public static void main(String[] args) throws IOException {
		new Problem11909_JW().solve();
	}

	private void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nn = Integer.parseInt(br.readLine());
		int[][] map = new int[nn][nn];
		for (int i = 0; i < nn; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < nn; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] F = new int[nn][nn];
		for (int[] f : F) Arrays.fill(f, (int)1e9);
		F[0][0] = 0;
		
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < nn; j++) {
				if (i-1 >= 0) {
					if (map[i][j] < map[i-1][j]) {
						F[i][j] = Math.min(F[i][j], F[i-1][j]);
					} else {
						F[i][j] = Math.min(F[i][j], F[i-1][j] + (map[i][j] - map[i-1][j] + 1));
					}
				}
				
				if (j-1 >= 0) {
					if (map[i][j] < map[i][j-1]) {
						F[i][j] = Math.min(F[i][j], F[i][j-1]);
					} else {
						F[i][j] = Math.min(F[i][j], F[i][j-1] + (map[i][j] - map[i][j-1] + 1));
					}
				}
			}
		}
		System.out.println(F[nn-1][nn-1]);
	}
}
