package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1660_JW {
	public static void main(String[] args) {
		new Problem1660_JW().run();
	}

	private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
         
        int s = 120;
        int[] T = new int[s];
        int[] A = new int[s];
        T[0] = 1; A[0] = 1;
        for (int i = 1; i < s ; i++) {
            T[i] = T[i-1] + (i+1);
            A[i] = A[i-1] + T[i];
        }
 
        int min = Integer.MAX_VALUE;
        int[][] DT = new int[s][N+1];
        for (int n = 0; n <= N; n++) DT[0][n] = n;
         
        for (int i = 1; i < s; i++) {
            for (int n = 1; n <= N; n++) {
                DT[i][n] = DT[i-1][n];
                if (n - A[i] >= 0) {
                    DT[i][n] = Math.min(DT[i-1][n], DT[i][n - A[i]] + 1);
                }
                 
                if (n == N) {
                    min = Math.min(min, DT[i][n]);
                }
            }
        }
        System.out.println(min);
	}
}
