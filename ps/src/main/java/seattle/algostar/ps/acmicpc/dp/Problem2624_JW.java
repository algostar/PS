package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2624_JW {
    public static void main(String[] args) {
        new Problem2624_JW().run();
         
    }
 
    int t,k;
    int[] P;
    int[] N;
    int[][] memo;
    private void run() {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        k = sc.nextInt();
        P = new int[k]; N = new int[k];
        for (int i = 0; i < k; i++) {P[i] = sc.nextInt(); N[i] = sc.nextInt();}
        memo = new int[t+1][k];
        for (int[] me : memo) Arrays.fill(me, -1);
         
        int r = f(t, -1);
        System.out.println(r);
    }
    private int f(int t, int ix) {
        if (t == 0) return 1;
        if (t < 0) return 0;
        if (ix != -1 && memo[t][ix] != -1) return memo[t][ix];
         
        int cases = 0;
 
        for (int i = ix + 1; i < k; i++) {
            for (int j = 1; j <= N[i]; j++) {
                int lt = t - (P[i] * j);
                if (lt < 0) break;
                cases += f(lt, i);
            }
        }
         
        return (ix != -1 ? memo[t][ix] = cases : cases);
    }
}
