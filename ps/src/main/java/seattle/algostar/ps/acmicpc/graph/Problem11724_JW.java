package seattle.algostar.ps.acmicpc.graph;

import java.util.Scanner;

public class Problem11724_JW {
	public static void main(String[] args) {
		new Problem11724_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		
		boolean[][] graph = new  boolean[nn+1][nn+1];
		for (int i = 0; i < mm; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = true;
			graph[v2][v1] = true;
		}
		
		boolean[] visit = new boolean[nn+1];
		
		int cnt = 0;
		
		for (int v = 1; v <= nn; v++) {
			if (!visit[v]) {
				cnt += go(v, graph, visit);
			}
		}
		System.out.println(cnt);
	}

	private int go(int v, boolean[][] graph, boolean[] visit) {
		visit[v] = true;
		
		for (int i = 1; i < visit.length; i++) {
			if (!visit[i] && graph[v][i]) {
				return go(i, graph, visit);
			}
		}
		return 1;
	}
}
