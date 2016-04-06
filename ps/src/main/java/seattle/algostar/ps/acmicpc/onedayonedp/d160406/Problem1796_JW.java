package seattle.algostar.ps.acmicpc.onedayonedp.d160406;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class Problem1796_JW {
	public static void main(String[] args) {
		new Problem1796_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();
		int nn = S.length;
		
		int L = 0, R = 1;
		int[][] idx = new int[27][2];
		for (int[] id : idx) Arrays.fill(id, -1);
		
		for (int i = 1; i <= nn; i++) {
			int ch = S[i-1] - 'a' + 1;
			idx[ch][L] = (idx[ch][L] == -1) ? i : Math.min(idx[ch][L], i);
			idx[ch][R] = Math.max(idx[ch][R], i);
		}
		
		int initL = 1;
		int initR = 1;
		for (int i = 0; i < 27; i++) {
			if (idx[i][L] == -1) {
				idx[i][L] = initL;
				idx[i][R] = initR;
			} else {
				initL = idx[i][L];
				initR = idx[i][R];
			}
		}
		
		int[][] F = new int[27][2];
		for(int[] f : F) Arrays.fill(f, (int)1e9);
		
		F[0][0] = 0;
		F[0][1] = 0;
		
		for (int i = 1; i < 27; i++) {
			if (idx[i-1][L] == idx[i][L] && idx[i-1][R] == idx[i][R]) {
				F[i][L] = F[i-1][L];
				F[i][R] = F[i-1][R];
			} else {
				int l1 = F[i-1][L] + getStepCnt(idx[i-1][L], idx[i][R]) + getStepCnt(idx[i][R], idx[i][L]);
				int l2 = F[i-1][R] + getStepCnt(idx[i-1][R], idx[i][R]) + getStepCnt(idx[i][R], idx[i][L]);
				F[i][L] = Math.min(l1, l2);
				int r1 = F[i-1][L] + getStepCnt(idx[i-1][L], idx[i][L]) + getStepCnt(idx[i][L], idx[i][R]);
				int r2 = F[i-1][R] + getStepCnt(idx[i-1][R], idx[i][L]) + getStepCnt(idx[i][L], idx[i][R]);
				F[i][R] = Math.min(r1, r2);
			}
		}
		System.out.println(Math.min(F[26][L], F[26][R]) + nn);
	}

	private int getStepCnt(int from, int to) {
		return Math.abs(from - to);
	}
}
