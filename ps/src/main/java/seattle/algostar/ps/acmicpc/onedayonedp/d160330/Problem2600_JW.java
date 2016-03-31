package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2600_JW {
	public static void main(String[] args) {
		new Problem2600_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		
		int[] V = new int[3];
		for (int i = 0; i < 3; i++) V[i] = sc.nextInt();
		
		for (int t = 0; t < 5; t++) {
			int k1 = sc.nextInt();
			int k2 = sc.nextInt();
			
			int[][][] SS = new int[k1+1][k2+1][3];
			
			int A = 0, B = 1;
			SS[0][0][A] = B;
			SS[0][0][B] = A;
			for (int i = 0; i <= k1; i++) {
				for (int j = 0; j <= k2; j++) {
					// A
					int aWin = 0;
					for (int v = 0; v < 3; v++) {
						if (i - V[v] >= 0 && SS[i - V[v]][j][B] == A) aWin++;
						if (j - V[v] >= 0 && SS[i][j - V[v]][B] == A) aWin++;
					}
					SS[i][j][A] = (aWin > 0) ? A : B;
					
					// B
					int bWin = 0;
					for (int v = 0; v < 3; v++) {
						if (i - V[v] >= 0 && SS[i - V[v]][j][A] == B) bWin++;
						if (j - V[v] >= 0 && SS[i][j - V[v]][A] == B) bWin++;
					}
					SS[i][j][B] = (bWin > 0) ? B : A;
				}
			}
			
			System.out.println(SS[k1][k2][A] == A ? "A" : "B");
		}
	}
}
