package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2579_JW3 {
	public static void main(String[] args) {
		new Problem2579_JW3().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		
		int[][] DT = new int[N][3];
		DT[0][1] = A[0];
		DT[1][1] = A[1]; DT[1][2] = A[0] + A[1];
		for (int i = 2; i < N; i++) {
			DT[i][1] = Math.max(DT[i-2][1], DT[i-2][2]) + A[i];
			DT[i][2] = DT[i-1][1] + A[i];
		} 
		
		System.out.println(Math.max(DT[N-1][1], DT[N-1][2]));
	}
}