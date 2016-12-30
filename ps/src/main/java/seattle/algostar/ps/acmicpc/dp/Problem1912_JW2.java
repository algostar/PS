package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1912_JW2 {
	public static void main(String[] args) {
		new Problem1912_JW2().solve();
	}

	private void solve() {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		
		int[] D = new int[N];
		D[0] = A[0];
		for (int i = 0; i < N-1; i++){
			D[i+1] = Math.max(D[i], 0) + A[i+1];
		}
		
		int max = (int)-1e9;
		for (int d : D) max = Math.max(max, d);
		System.out.println(max);
	}
}
