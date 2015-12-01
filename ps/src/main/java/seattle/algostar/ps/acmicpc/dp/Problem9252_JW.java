package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9252_JW {
	public static void main(String[] args) {
		new Problem9252_JW().run();
	}

	char[] s1, s2;
	int[][] memo;
	char[][] path;
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		s1 = sc.next().toCharArray();
		s2 = sc.next().toCharArray();
		memo = new int[s1.length][s2.length];
		path = new char[s1.length][s2.length];
		for (int[] m : memo)
			Arrays.fill(m, -1);
		
		for (char[] p : path) Arrays.fill(p, '-');
		
		System.out.println(f(s1.length - 1, s2.length - 1));
		
		print(s1.length-1, s2.length-1);
	}

	private void print(int i, int j) {
		if (i < 0 || j < 0) return;
		
		char direct = path[i][j];
		
		int ni = -1, nj = -1;
		if (direct == 'C') {
			ni = i - 1;
			nj = j - 1;
			
		} else if (direct == 'U') {
			ni = i - 1;
			nj = j;
		} else if (direct == 'L') {
			ni = i;
			nj = j - 1;
		}
		
		print(ni, nj);
		
		if (direct == 'C') System.out.print(s1[i]);
	}

	private int f(int i, int j) {
		if (i < 0 || j < 0)
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];

		int lcs = 0;
		if (s1[i] == s2[j]) {
			lcs += f(i - 1, j - 1) + 1;
			path[i][j] = 'C';
		} else {
			int a = f(i - 1, j);
			int b = f(i, j - 1);
			lcs += Math.max(a, b);
			if(a > b){
				path[i][j] = 'U';
			} else {
				path[i][j] = 'L';
			}
		}

		return memo[i][j] = lcs;
	}
}
