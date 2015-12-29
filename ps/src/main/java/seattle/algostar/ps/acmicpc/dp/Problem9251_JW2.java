package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem9251_JW2 {
	public static void main(String[] args) {
		new Problem9251_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] s1 = sc.next().toCharArray();
		char[] s2 = sc.next().toCharArray();
		int[][] DT = new int[s1.length+1][s2.length+1];
		int max = 0;
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				if (s1[i] == s2[j]) {
					DT[i+1][j+1] = DT[i][j] + 1;
					max = Math.max(DT[i][j]+1, max);
				} else {
					DT[i+1][j+1] = Math.max(DT[i][j+1], DT[i+1][j]);
				}
			}
		}
		
		System.out.println(max);
	}
}
