package seattle.algostar.ps.acmicpc.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2096_JW {
	public static void main(String[] args) throws Exception {
		new Problem2096_JW().run();
	}

	int N;
	int[][] A;
	int[][] minDP;
	int[][] maxDP;
	private void run() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N][3];
		minDP = new int[N][3];
		maxDP = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] num = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(num[j]);
				if (i == 0) {
					minDP[i][j] = A[i][j];
					maxDP[i][j] = A[i][j];
				}
			}
		}
		
		for (int i = 1; i < N; i++) {
				minDP[i][0] = Math.min(minDP[i-1][0], minDP[i-1][1]) + A[i][0];
				minDP[i][1] = Math.min(Math.min(minDP[i-1][0], minDP[i-1][1]), minDP[i-1][2]) + A[i][1];
				minDP[i][2] = Math.min(minDP[i-1][1], minDP[i-1][2]) + A[i][2];
				
				maxDP[i][0] = Math.max(maxDP[i-1][0], maxDP[i-1][1]) + A[i][0];
				maxDP[i][1] = Math.max(Math.max(maxDP[i-1][0], maxDP[i-1][1]), maxDP[i-1][2]) + A[i][1];
				maxDP[i][2] = Math.max(maxDP[i-1][1], maxDP[i-1][2]) + A[i][2];
		}
		
		int min = Math.min(Math.min(minDP[N-1][0], minDP[N-1][1]), minDP[N-1][2]);
		int max = Math.max(Math.max(maxDP[N-1][0], maxDP[N-1][1]), maxDP[N-1][2]);
		System.out.println(max + " " + min);
	}
}
