package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2624_JW1 {
    public static void main(String[] args) {
        new Problem2624_JW1().run();
         
    }
 
    int t,k;
    Coin[] coins;
    int[][] memo;
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        k = sc.nextInt();
        coins = new Coin[k];
        for (int i = 0; i < k; i++) {coins[i] = new Coin(sc.nextInt(), sc.nextInt());}
        Arrays.sort(coins);
        
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
            for (int j = 1; j <= coins[i].count; j++) {
                int lt = t - (coins[i].value * j);
                if (lt < 0) break;
                cases += f(lt, i);
            }
        }
         
        return (ix != -1 ? memo[t][ix] = cases : cases);
    }
    
    class Coin implements Comparable<Coin> {
    	int value;
    	int count;
    	public Coin(int v, int c) {
    		this.value = v;
    		this.count = c;
		}
		public int compareTo(Coin o) {
			return -(this.value - o.value);
		}
    }
}
