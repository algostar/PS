package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem10942_JW {
	public static void main(String[] args) {
		new Problem10942_JW().solve();
	}

	Boolean[][] DT;
	int[] A;
	
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N+1];
		for (int i = 1; i <= N; i++) A[i] = sc.nextInt();
		
		DT = new Boolean[N+1][N+1];
		
		for (int e = 1; e <= N; e++) {
			for (int s = e; s >= 0; s--) {
				if (s == e) {
					DT[s][e] = true;
					continue;
				}
				
				if (A[e] == A[s]) {
					boolean isPalin = DT[s+1][e-1];
					DT[s][e] = isPalin;
				} else {
					DT[s][e] = false;
				}
			
			}
		}
		
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println((DT[s][e]) ? 1 : 0);
		}
	}

}
