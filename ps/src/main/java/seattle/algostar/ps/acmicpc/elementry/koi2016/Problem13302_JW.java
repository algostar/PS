package seattle.algostar.ps.acmicpc.elementry.koi2016;

import java.util.Arrays;
import java.util.Scanner;

public class Problem13302_JW {
	public static void main(String[] args) {
		new Problem13302_JW().solve();
	}

	int T, N;
	int[][] D;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		N = sc.nextInt();
		boolean[] schedule = new boolean[T+2];
		Arrays.fill(schedule, true);
		for (int i = 0; i < N; i++) {
			schedule[sc.nextInt()] = false;
		}
		
		D = new int[T+1][2*T+1];
		for (int[] c : D) Arrays.fill(c, -1);

		D[0][0] = 0;
		for (int i = 0; i <= T; i++) {
			for (int j = 0; j <= i*2; j++) {
				if (D[i][j] == -1) continue;
				if (!schedule[i+1]) update(i + 1, j, D[i][j]);
				if (j >= 3) {
					update(i + 1, j-3, D[i][j]);
				}
				
				update(i + 1, j, D[i][j] + 10000);
				
				update(i + 1, j+1, D[i][j] + 25000);
				update(i + 2, j+1, D[i][j] + 25000);
				update(i + 3, j+1, D[i][j] + 25000);
				
				update(i + 1, j+2, D[i][j] + 37000);
				update(i + 2, j+2, D[i][j] + 37000);
				update(i + 3, j+2, D[i][j] + 37000);
				update(i + 4, j+2, D[i][j] + 37000);
				update(i + 5, j+2, D[i][j] + 37000);
			}
		}
		
		int res = D[T][0];
		for (int j = 0; j < 2*T; j++) {
			res = Math.min(D[T][j], res);
		}
		System.out.println(res);
	}
	
	private void update(int i, int j, int v) {
		if (i > T) return;
		if (D[i][j] == -1) D[i][j] = v;
		if (D[i][j] > v) D[i][j] = v;
	}
}
