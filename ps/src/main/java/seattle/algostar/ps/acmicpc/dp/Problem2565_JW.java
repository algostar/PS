package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2565_JW {
	public static void main(String[] args) {
		new Problem2565_JW().run();
	}		

	int N;
	Line[] lines;
	int[] memo;
	private void run() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		lines = new Line[N+1];
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		lines[0] = new Line(0, 0);
		for (int i = 1; i <= N; i++) {
			lines[i] = new Line(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(lines);
		
		int lis = f(0) - 1;
		System.out.println(N - lis);
	}
	
	private int f(int ix) {
		if (memo[ix] != -1) return memo[ix];
		
		int lis = 1;
		
		for (int i = ix+1; i <= N; i++) {
			if (lines[ix].r < lines[i].r) {
				lis = Math.max(lis, f(i) + 1);
			}
		}
		
		return memo[ix] = lis;
	}

	class Line implements Comparable<Line> {
		int l;
		int r;
		
		public Line(int l, int r) {
			this.l = l;
			this.r = r;
		}

		public int compareTo(Line o) {
			return this.l - o.l;
		}
	}
}
