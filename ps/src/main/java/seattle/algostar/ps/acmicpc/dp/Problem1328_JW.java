package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1328_JW {
	public static void main(String[] args) {
		new Problem1328_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int ll = sc.nextInt();
		int rr = sc.nextInt();
		
		int[][][] DT = new int[nn+1][ll+1][rr+1];
		
		DT[1][1][0] = 1;
		DT[1][0][1] = 1;
		for (int n = 2; n <= nn; n++) {
			for (int l = 0; l <= ll; l++) {
				for (int r = 0; r <= rr; r++) {
					if (l >= 1)
						DT[n][l][r] += DT[n-1][l-1][r];
					if (r >= 1)
						DT[n][l][r] += DT[n-1][l][r-1];
				}
			}
		}
		
		System.out.println(DT[nn][ll][rr]);
		
	}
}
