package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Arrays;
import java.util.Scanner;

public class Problem5502_JW {
	public static void main(String[] args) {
		new Problem5502_JW().solve();
	}
	

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int nn = sc.nextInt();
        char[] S = sc.next().toCharArray();
         
        int[][] SS = new int[nn][nn];
         
        for (int s = nn-1; s >= 0; s--) {
            SS[s][s] = 0;
            for (int e = s+1; e < nn; e++) {
                if (S[s] == S[e]) {
                    SS[s][e] = (e - s == 1) ? 0 : SS[s+1][e-1];
                } else {
                    SS[s][e] = Math.min(SS[s+1][e], SS[s][e-1]) + 1;
                }
            }
        }
        System.out.println(SS[0][nn-1]);
    }
}
