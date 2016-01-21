package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1028_JW {
	public static void main(String[] args) {
		new Problem1028_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] map = new char[R][];
		for (int i = 0; i < R; i++) map[i] = sc.next().toCharArray();
		
		int[][] V = new int[R][C];
		int[][] H = new int[R][C];
		for (int i = 0; i < R; i++) if (map[i][0] == '1') V[i][0] = 1;
		for (int j = 0; j < C; j++) if (map[0][j] == '1') H[0][j] = 1;
		
		int max = 0;
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				
				if (map[i][j] == '1') {
					V[i][j] = Math.min(V[i-1][j] + 1, V[i][j-1]);
					H[i][j] = Math.min(H[i-1][j], H[i][j-1] + 1);
					max = Math.max(max, Math.min(V[i][j], H[i][j]));
				}
			}
		}
		System.out.println(max);
	}
}

