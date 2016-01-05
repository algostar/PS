package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2602_JW {
	public static void main(String[] args) {
		new Problem2602_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		char[] T = sc.next().toCharArray();
		char[][] S = new char[2][];
		S[0] = sc.next().toCharArray();
		S[1] = sc.next().toCharArray();
		
		int N = T.length;
		int M = S[0].length;
		
		int[][][] DT = new int[N][2][M];
		// init
		for (int t = 0; t < 2; t++) {
			for (int i = 0; i < M; i++) {
				if (T[0] == S[t][i]) {
					DT[0][t][i]++;
				}
				if (i > 0) {
					DT[0][t][i] += DT[0][t][i - 1];
				}
			}
		}
		//dp
		for (int ix = 1; ix < N; ix++) {
			for (int t = 0; t < 2; t++) {
				for (int i = 0; i < M; i++) {
					if (T[ix] == S[t][i]) {
						if (ix > 0 && i > 0) {
							DT[ix][t][i] += DT[ix - 1][1 - t][i - 1]; 
						}
					} 
					if (i > 0) {
						DT[ix][t][i] += DT[ix][t][i - 1];
					}
				}
			}
		}
		
		System.out.println(DT[N-1][0][M-1] + DT[N-1][1][M-1]);
	}
}
