package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9252_JW {
	public static void main(String[] args) {
		new Problem9252_JW().run();
	}

	char[] s1, s2;
	int[][] memo;
	int[] pathI;
	int[] pathJ;

	private void run() {
		Scanner sc = new Scanner(System.in);
		s1 = sc.next().toCharArray();
		s2 = sc.next().toCharArray();
		memo = new int[s1.length][s2.length];
		pathI = new int[s1.length];	Arrays.fill(pathI, -1);
		pathJ = new int[s2.length];	Arrays.fill(pathJ, -1);
		for (int[] m : memo)
			Arrays.fill(m, -1);

		System.out.println(f(s1.length - 1, s2.length - 1));
		
		print(s1.length-1, s2.length-1);
	}

	private void print(int i, int j) {
		if (i <= 0 || j <= 0) return;
		
		if(s1[i] == s2[j]){
			System.out.println(s1[i] + " ");
		}
		//System.out.print(s1[i] + "/" + s2[j] + " ");
		
		print(pathI[i], pathJ[j]);
	}

	private int f(int i, int j) {
		if (i < 0 || j < 0)
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];

		int lcs = 0;
		if (s1[i] == s2[j]) {
			lcs += f(i - 1, j - 1) + 1;
			pathI[i] = i-1;
			pathJ[j] = j-1;
		} else {
			int a = f(i - 1, j);
			int b = f(i, j - 1);
			lcs += Math.max(a, b);
			if(a > b){
				pathI[i] = i-1;
				pathJ[j] = j;
			}else{
				pathI[i] = i;
				pathJ[j] = j-1;
			}
		}

		return memo[i][j] = lcs;
	}
}
