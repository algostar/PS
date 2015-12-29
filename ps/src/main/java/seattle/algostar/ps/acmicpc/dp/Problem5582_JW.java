package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem5582_JW {
	public static void main(String[] args) {
		new Problem5582_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		char[] S1 = sc.next().toCharArray();
		char[] S2 = sc.next().toCharArray();
		int max = 0;
		int[] DT = new int[S2.length+1];
		for (int i = 0; i < S1.length; i++) {
			for (int j = S2.length-1; j >= 0; j--) {
				if (S1[i] == S2[j]) {
					DT[j+1] = DT[j] + 1;
				} else {
					DT[j+1] = 0;
				}
				max = Math.max(DT[j+1], max);
			}
		}
		System.out.println(max);
	}
}
