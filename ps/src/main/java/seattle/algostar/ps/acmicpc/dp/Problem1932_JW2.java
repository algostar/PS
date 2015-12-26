package seattle.algostar.ps.acmicpc.dp;

import java.util.*;

public class Problem1932_JW2 {
	public static void main(String[] args) {
		new Problem1932_JW2().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		int max = 0;
		int[] DT = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = i; j >= 1; j--) {
				DT[j] = Math.max(DT[j-1], DT[j]) + sc.nextInt();
				max = Math.max(max, DT[j]);
			}
		}
		System.out.println(max);
	}
}
