package seattle.algostar.ps.acmicpc.dfs;

import java.util.Scanner;

public class Problem1405_JW {
	public static void main(String[] args) {
		new Problem1405_JW().run();
	}

	double[] P = new double[4];
	int size = 29;
	boolean[][] map = new boolean[size][size];;
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < 4; i++) P[i] = (sc.nextInt() * 0.01);
		int sy = size/2;
		int sx = size/2;
		map[sy][sx] = true;
		double ret = f(sy, sx, n, 1);
		System.out.printf("%.10f", ret);
		
	}
	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};
	private double f(int y, int x, int n, double p) {
		if (n == 0) return p;
		
		double sumP = 0.0;
		
		for (int d = 0; d < 4; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;
			if (map[ny][nx]) continue;
			map[ny][nx] = true;
			sumP += f(ny, nx, n - 1, p * P[d]);
			map[ny][nx] = false;
		}
		
		return sumP;
	}
}
