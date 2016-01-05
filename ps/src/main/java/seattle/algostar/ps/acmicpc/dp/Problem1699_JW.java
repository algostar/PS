package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1699_JW {
	public static void main(String[] args) {
		new Problem1699_JW().solve();
	}

	private void solve() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
         
        int s = 317;
        int[] A = new int[s];
        for (int i = 1; i < s ; i++) {
        	A[i] = i*i;
        }
 
        int[] DT = new int[N+1];
        for (int n = 0; n <= N; n++) DT[n] = n;
         
        for (int i = 1; i < s; i++) {
            if (A[i] > N) break;
            for (int n = A[i]; n <= N; n++) {
                DT[n] = Math.min(DT[n], DT[n - A[i]] + 1);
            }
        }
        System.out.println(DT[N]);		
	}
}
