package seattle.algostar.ps.acmicpc.book.mid;

import java.util.Scanner;

public class Problem_P85_JW {
	public static void main(String[] args) {
		new Problem_P85_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		
		boolean[][] isPossBoard = new boolean[nn][nn];
		for (int x = 0; x < nn; x++) {
			go(0, x, isPossBoard);
		}
		
	}

	private int go(int y, int x, boolean[][] isPossBoard) {
		int possCnt = 0;
		
		if (y == isPossBoard.length-1) {
			for (int nx = 0; nx < isPossBoard[y].length-1; nx++) {
				if (isPossBoard[y][nx]) {
					return 1;
				}
			}
			return 0;
		}
		
		
		makeImpossBoard(y, x, isPossBoard);
		
		
		if (isPossBoard[y][x]) {
			for (int nx = 0; nx < isPossBoard[y].length-1; nx++) {
				if (isPossBoard[y][nx]) {
					possCnt = go(y + 1, nx, isPossBoard);
				}
			}
		}
		
		return possCnt;
	}

	private void makeImpossBoard(int y, int x, boolean[][] isPossBoard) {
		
	}
}
