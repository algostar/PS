package seattle.algostar.ps.acmicpc.elementry.koi2016;

import java.util.HashMap;
import java.util.Scanner;

public class Problem13300_JW {
	public static void main(String[] args) {
		new Problem13300_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int kk = sc.nextInt();
		int[][] genderGrade = new int[2][7];
		for (int i = 0; i < nn; i++) {
			int g = sc.nextInt();
			int G = sc.nextInt();
			genderGrade[g][G]++;
		}
		
		int totalCnt = 0;
		for (int g = 0; g < 2; g++) {
			for (int G = 1; G < 7; G++) {
				totalCnt += (genderGrade[g][G] / kk) + (genderGrade[g][G] % kk > 0 ? 1 : 0);
			}
		}
		System.out.println(totalCnt);
	}
}
