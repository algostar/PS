package seattle.algostar.ps.acmicpc.elementry.sido.si2004;

import java.util.Scanner;

public class Problem2606_JW {
	public static void main(String[] args) {
		new Problem2606_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int cc = sc.nextInt();
		boolean[][] connect = new boolean[nn+1][nn+1];
		for (int c = 0; c < cc; c++) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			connect[c1][c2] = true;
			connect[c2][c1] = true;
		}
		boolean[] visit = new boolean[nn+1];
		int cnt = count(1, connect, visit);
		System.out.println(cnt - 1);
	}

	private int count(int curNode, boolean[][] connect, boolean[] visit) {
		if (visit[curNode]) return 0;
		
		int cnt = 1;
		visit[curNode] = true;
		
		for (int node = 1; node < visit.length; node++) {
			if (!visit[node] && connect[node][curNode]) {
				cnt += count(node, connect, visit); 
			}
		}
		return cnt;
	}
}
