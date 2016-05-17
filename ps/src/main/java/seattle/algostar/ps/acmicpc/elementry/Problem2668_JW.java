package seattle.algostar.ps.acmicpc.elementry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2668_JW {
	public static void main(String[] args) {
		new Problem2668_JW().solve();
	}

	int IMPOSSIBLE = -1;
	int POSSIBLE = 1;
	boolean[] visited;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		
		int nn = sc.nextInt();

		int[] A = new int[nn+1];
		int[] isPossible = new int[nn+1];
		visited = new boolean[nn+1];
		
		for (int i = 1; i <= nn; i++) {
			A[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= nn; i++) {
			if (isPossible[i] == 0) {
				visited[i] = true;
				go(i, i, A, isPossible);
				visited[i] = false;
			}
		}
		
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 1; i <= nn; i++) {
			if (isPossible[i] == POSSIBLE) {
				ret.add(i);
			}
		}
		System.out.println(ret.size());
		for (int n : ret) {
			System.out.println(n);
		}
	}

	private boolean go(int start, int ix, int[] A, int[] isPossible) {
		int next = A[ix];
		
		if (visited[next]) return false;
		
		if (start != ix && next == ix) {
			return false;
		}
		
		if (start == next) {
			isPossible[ix] = POSSIBLE;
			isPossible[start] = POSSIBLE;
			return true;
		}
		
		if (isPossible[next] == 0)  {
			visited[next] = true;
			boolean ret = go(start, next, A, isPossible);
			visited[next] = false;
			isPossible[ix] = (ret) ? POSSIBLE : IMPOSSIBLE;
			return ret;
		} else {
			isPossible[ix] = IMPOSSIBLE;
			return false;
		}
	}
}
