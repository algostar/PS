package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem11052_JW3 {
	public static void main(String[] args) {
		new Problem11052_JW3().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N+1];
		for (int i = 1; i <= N; i++) A[i] = sc.nextInt();
		
		int[] D =  new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 1; i + j <= N; j++) {
				D[i+j] = Math.max(D[i] + A[j], D[i+j]);  
			}
		}
		System.out.println(D[N]);
	}
}
