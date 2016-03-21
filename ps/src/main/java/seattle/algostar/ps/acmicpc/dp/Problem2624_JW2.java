package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2624_JW2 {
    public static void main(String[] args) {
        new Problem2624_JW2().solve();
         
    }
    
    private void solve() {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        int kk = sc.nextInt();
        int[] P = new int[kk];
        int[] C = new int[kk];
        for (int i = 0; i < kk; i++) {
        	P[i] = sc.nextInt();
        	C[i] = sc.nextInt();
        }
        
        int[][] DT = new int[kk][tt+1];
        
    	for (int n = 0; n <= C[0]; n++) {
    		if (P[0] * n <= tt) {
    			DT[0][P[0] * n] = 1;
    		}
    	}
        
        for (int i = 1; i < kk; i++) {
        	for (int t = 0; t <= tt; t++) {
        		for (int n = 0; n <= C[i]; n++) {
        			if (t >= P[i]*n) {
        				DT[i][t] += DT[i-1][t - P[i]*n];
        			}
        		}
        	}
        }
        System.out.println(DT[kk-1][tt]);
    }
}