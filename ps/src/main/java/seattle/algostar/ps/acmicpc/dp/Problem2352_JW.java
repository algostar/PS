package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2352_JW {
	public static void main(String[] args) {
		new Problem2352_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int[] in = new int[nn+1];
		for (int i = 1; i <= nn; i++) in[i] = sc.nextInt();
		
		int[] DT = new int[nn+1];
		Arrays.fill(DT, 1);
		int max = 0;
		for (int i = 1; i <= nn; i++) {
			for (int j = i-1; j >= 1; j--) {
				if (in[i] > in[j]) {
					DT[i] = Math.max(DT[i], DT[j] + 1);
					max = Math.max(max, DT[i]);
				}
			}
		}
		System.out.println(max);
	}
}
