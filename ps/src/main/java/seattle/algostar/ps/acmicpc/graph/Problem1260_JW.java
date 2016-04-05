package seattle.algostar.ps.acmicpc.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1260_JW {
	public static void main(String[] args) {
		new Problem1260_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		int sv = sc.nextInt();
		boolean[][] graph = new boolean[nn+1][nn+1];
		for (int i = 0; i < mm; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = true;
			graph[v2][v1] = true;
		}
		boolean[] visit = new boolean[nn+1];
		dfs(graph, sv, visit);
		Arrays.fill(visit, false);
		System.out.println();
		bfs(graph, sv, visit);
	}

	private void bfs(boolean[][] graph, int sv, boolean[] visit) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(sv);
		visit[sv] = true;
		
		while (!que.isEmpty()) {
			int v = que.poll();
			System.out.print(v + " ");
			
			for (int i = 1; i < graph.length; i++) {
				if (graph[v][i] && !visit[i]) {
					visit[i] = true;
					que.add(i);
				}
			}
		}
	}

	private void dfs(boolean[][] graph, int v, boolean[] visit) {
		visit[v] = true;
		System.out.print(v);
		
		for (int i = 1; i < graph.length; i++) {
			if (graph[v][i] && !visit[i]) {
				System.out.print(' ');
				dfs(graph, i, visit);
			}
		}
	}
}
