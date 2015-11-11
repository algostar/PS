package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1149_JW2 {
	public static void main(String[] args) {
		new Problem1149_JW2().run();
	}

    int RED = 0;
    int GREEN = 1;
    int BLUE = 2;
    int[] colors = {RED, GREEN, BLUE};
     
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] costA = new int[n][3];
        for (int i = 0; i < n; i++) {
            costA[i][RED] = sc.nextInt();
            costA[i][GREEN] = sc.nextInt();
            costA[i][BLUE] = sc.nextInt();
        }
         
        int minCost = Integer.MAX_VALUE;
        for (int color : colors) {
            memo = new int[n][3];
            minCost = Math.min(minCost, getMinCost(0, color, costA));
        }
         
        System.out.println(minCost);
    }
 
    int[][] memo;
     
    private int getMinCost(int ix, int color, int[][] costA) {
        if (ix > costA.length - 1) return 0;
         
        if (memo[ix][color] != 0) return memo[ix][color];
         
        int cost = costA[ix][color];
         
        int subCost = Integer.MAX_VALUE;
        for (int c : colors) {
            if (color != c) {
                subCost = Math.min(subCost, getMinCost(ix + 1, c, costA));
            }
        }
         
        return memo[ix][color] = (cost + subCost);
    }
}
