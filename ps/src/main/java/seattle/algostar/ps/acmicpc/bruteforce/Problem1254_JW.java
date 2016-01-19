package seattle.algostar.ps.acmicpc.bruteforce;

import java.util.Scanner;

public class Problem1254_JW {
	public static void main(String[] args) {
		new Problem1254_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();
		int n = S.length;
		int i, j;
		i = 1;
		j = 1;
		
		int minAddLen = Integer.MAX_VALUE;
		while (i < n && j < n) {
			//
			int len = getSameLength(S, i, j);
			
			if (len > 0) {
				int leftSize = i + 1;
				int rightSize = n - j;
				minAddLen = Math.min(minAddLen, leftSize - rightSize);
			}
			i++;
			
		}
		System.out.println(minAddLen);
	}

	private int getSameLength(char[] S, int i, int j) {
		
		int len = 0;
		while (0 <= i && j < S.length) {
			if (S[i] == S[j]) {
				len++;
			}
			i--;
			j++;
		}
		return len;
	}
}
