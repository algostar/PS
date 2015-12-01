package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Problem10164_JW {
	public static void main(String[] args) throws IOException {
		new Problem10164_JW().run();
	}
	int n, m, k;
	boolean[][] map;
	int[][][] memo;
	private void run() throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		// y
		m = sc.nextInt();		// x
		k = sc.nextInt();
		map = new boolean[n][m];
		if (k != 0) {
			int y = (k-1) / m;
			int x = (k-1) % m;
			map[y][x] = true;
		}
		memo = new int[n][m][2];
		for (int[][] me : memo) for (int[] m : me) Arrays.fill(m, -1);
		
		int ret = f(0, 0, 0);
		System.out.println(ret);
	}
	int[] dy = {0, 1};
	int[] dx = {1, 0};
	private int f(int y, int x, int cnt) {
		if (memo[y][x][cnt] != -1) return memo[y][x][cnt];
		
		if (map[y][x]) cnt++;
		
		if (x == m-1 && y == n-1) {
			if (k == 0 || cnt == 1) return 1;
			else return 0;
		}
		
		int total = 0;
		for (int i = 0; i < dy.length; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < n && nx < m) {
				total += f(ny, nx, cnt);
			}
		}
		return memo[y][x][cnt] = total;
	}
}
