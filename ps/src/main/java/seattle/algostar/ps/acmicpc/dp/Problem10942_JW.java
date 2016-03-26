package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem10942_JW {
	public static void main(String[] args) {
		new Problem10942_JW().solve();
	}

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int nn = sc.nextInt();
        int[] A = new int[nn+1];
        for (int i = 1; i <= nn; i++) A[i] = sc.nextInt();
         
        boolean[][] DT = new boolean[nn+2][nn+2];
         
        for (int s = nn; s >= 1; s--) {
            DT[s][s] = true;
            for (int e = s + 1; e <= nn; e++) {
                if (A[s] == A[e]) {
                    DT[s][e] = (e - s == 1) ? true : DT[s+1][e-1];
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
