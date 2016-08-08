package seattle.algostar.ps.acmicpc.elementry.sido.si2005;

import java.util.Scanner;

public class Problem2589_JW {
	public static void main(String[] args) {
		new Problem2589_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		
		char[][] map = new char[nn][mm];
		for (int i = 0; i < nn; i++) {
			map[i] = sc.next().toCharArray();
		}

		for (int y = 0; y < nn; y++) {
			for (int x = 0; x < mm; x++) {
				boolean[][] visit = new boolean[nn][mm];
				int longestDist = getLongestDistance(x, y, visit);
			}
		}
		
	}

	private int getLongestDistance(int x, int y, boolean[][] visit) {
		return 0;
	}
}
