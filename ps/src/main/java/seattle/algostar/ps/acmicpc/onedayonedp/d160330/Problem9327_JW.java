package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Scanner;

public class Problem9327_JW {
	public static void main(String[] args) {
		new Problem9327_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			int nn = sc.nextInt();
			int e = sc.nextInt();
			
			int[] V = new int[nn];
			for (int i = 0; i < nn; i++) {
				V[i] = sc.nextInt();
			}
			
			boolean[] isPoss = new boolean[4000*102 + 1];
			isPoss[0] = true;
			for (int i = 0; i < nn; i++) {
				for (int j = 4000*100; j >= 0; j--) {
					if (isPoss[j]) {
						isPoss[j + 2 * V[i]] = true;
					}
				}
			}
			
			boolean found = false;
			for (int i = e; i <= 4000*102; i++) {
				if (isPoss[i]) {
					System.out.println(i/2);
					found = true;
					break;
				}
			}
			
			if (!found) System.out.println("FULL");
		}
	}
}
