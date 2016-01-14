package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2624_JW2 {
    public static void main(String[] args) {
        new Problem2624_JW2().solve();
         
    }
    
    private void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int K = sc.nextInt();
        int[] P = new int[K];
        int[] C = new int[K];
        for (int i = 0; i < K; i++) {
        	P[i] = sc.nextInt();
        	C[i] = sc.nextInt();
        }
        
        int[][] DT = new int[K][T+1];
        // init
        for (int i = 1; i < K; i++) {
        }
        System.out.println(DT[K-1][T]);
    }
}