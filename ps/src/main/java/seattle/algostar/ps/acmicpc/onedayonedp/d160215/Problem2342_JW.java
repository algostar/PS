package seattle.algostar.ps.acmicpc.onedayonedp.d160215;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2342_JW {
	public static void main(String[] args) throws IOException {
		new Problem2342_JW().solve();
	}

	private void solve() throws IOException {
		int[] A = new int[100001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ix = 0;
		while (true) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) break;
			A[ix++] = num;
		}
		
		int N = ix;
		int[][][] DT = new int[N+1][5][5];
		for (int i = 0; i <= N; i++) {
			for (int l = 0; l < 5; l++) {
				Arrays.fill(DT[i][l], (int)1e9);
			}
		}
		
		DT[0][0][0] = 0;
		
		for (int i = 0; i < N; i++) {
			for (int l = 0; l < 5; l++) {
				for (int r = 0; r < 5; r++) {
					int to = A[i];
					
					if (to != r) {
						DT[i+1][to][r] = Math.min(DT[i+1][to][r], DT[i][l][r] + score(l, to));
					}
					
					if (to != l) {
						DT[i+1][l][to] = Math.min(DT[i+1][l][to], DT[i][l][r] + score(r, to));
					}
				}
			} 
		}
		
		int min = (int)1e9;
		for (int i = 0; i < 5; i++) {
				min = Math.min(min, DT[N][i][A[N-1]]);
				min = Math.min(min, DT[N][A[N-1]][i]);
		}
		
		System.out.println(min);
	}

	private int score(int from, int to) {
		if (from == to) return 1;
		else if (from == 0 || to == 0) return 2;
		else if (Math.abs(from - to) == 2) return 4;
		return 3;
	}
}
