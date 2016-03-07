package seattle.algostar.ps.acmicpc.onedayonedp.d160302;

import java.util.Scanner;

public class Problem1577_JW {
    public static void main(String[] args) {
        new Problem1577_JW().solve();
    }
 
    private void solve() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
         
        int K = sc.nextInt();
 
        int[][] B = new int[K][4];
        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            B[i][0] = Math.min(a, c);
            B[i][1] = Math.min(b, d);
            B[i][2] = Math.max(a, c);
            B[i][3] = Math.max(b, d);
        }
         
        long[][] DT = new long[N+1][M+1];
        DT[0][0] = 1;
         
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
            	int code = getBlockCode(x, y, B);
                if (code == 1) DT[y][x] += DT[y][x - 1];
                if (code == 2) DT[y][x] += DT[y - 1][x];
            }
        }
        System.out.println(DT[N][M]);
    }

	private int getBlockCode(int x, int y, int[][] B) {
		for (int i = 0; i < B.length; i++) {
			if (B[i][2] == x && B[i][3] == y) {
				if (B[i][0] == x - 1 && B[i][1] == y) return 1;
				if (B[i][0] == x && B[y][1] == y - 1) return 2;
			}
		}
		return 0;
	}
}
