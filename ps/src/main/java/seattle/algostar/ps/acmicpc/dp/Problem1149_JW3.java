package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1149_JW3 {
	public static void main(String[] args) {
		new Problem1149_JW3().run();
	}

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][3];
        for (int i = 0; i < N; i++) {
        	for (int c = 0; c < 3; c++) {
        		A[i][c] = sc.nextInt();
        	}
        }
        
        int[][] DT = new int[2][3];
        for (int c = 0; c < 3; c++) DT[0][c] = A[0][c];
        for (int i = 1; i < N; i++) {
       		DT[i%2][0] = Math.min(DT[(i-1)%2][1], DT[(i-1)%2][2]) + A[i][0];
       		DT[i%2][1] = Math.min(DT[(i-1)%2][0], DT[(i-1)%2][2]) + A[i][1];
       		DT[i%2][2] = Math.min(DT[(i-1)%2][1], DT[(i-1)%2][0]) + A[i][2];
        }
        int min = Math.min(DT[(N-1)%2][0], Math.min(DT[(N-1)%2][1], DT[(N-1)%2][2]));
        System.out.println(min);
    }
}
