package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem10164_JW2 {
	public static void main(String[] args) {
		new Problem10164_JW2().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int s = 1;
		int tx = -1, ty = -1;
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s;
				if (s == K) {
					ty = i;
					tx = j;
				}
				s++;
			}
		}
		
		int target = 0;
		int[][][] DT = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			DT[i][0][0] = 1;
			if (i == ty && 0 == tx || target == 1) {
				DT[i][0][1] = 1;
				target = 1;
			}
		}
		target = 0;
		for (int j = 0; j < M; j++) {
			DT[0][j][0] = 1;
			if (0 == ty && j == tx || target == 1) {
				DT[0][j][1] = 1;
				target = 1;
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				DT[i][j][0] = DT[i-1][j][0] + DT[i][j-1][0];
				
				if (i == ty && j == tx) {
					DT[i][j][1] = DT[i-1][j][0] + DT[i][j-1][0]; 
				} else {
					DT[i][j][1] = DT[i-1][j][1] + DT[i][j-1][1];
				}
			}
		}
		if (DT[N-1][M-1][1] != 0) {
			System.out.println(DT[N-1][M-1][1]);
		} else {
			System.out.println(DT[N-1][M-1][0]);
		}
	}
}
