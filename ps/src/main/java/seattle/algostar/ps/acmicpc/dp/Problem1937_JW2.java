package seattle.algostar.ps.acmicpc.dp;

import java.util.*;

public class Problem1937_JW2 {
	public static void main(String[] args) {
		new Problem1937_JW2().solve();
	}
	
	int[][] map;
	List<P> point;
	int[][] DT;
	int N;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		point = new ArrayList<P>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				point.add(new P(i, j, map[i][j]));
			}
		}
		Collections.sort(point);
		
		DT = new int[N][N];
		int ret = 0;
		for (int i = 0; i < point.size(); i++) {
			int[] dy = {0, 0, 1, -1};
			int[] dx = {1, -1, 0, 0};
			P cur = point.get(i);
			for (int d = 0; d < 4; d++) {
				int py = dy[d] + cur.y;
				int px = dx[d] + cur.x;
				int maxLen = DT[cur.y][cur.x];
				if (0 <= py && py < N && 0 <= px && px < N) {
					if (map[py][px] < map[cur.y][cur.x]) {
						maxLen = Math.max(maxLen, DT[py][px] + 1);
						DT[py][px] = maxLen;
					}
				}
				ret = Math.max(maxLen, ret);
			}
		}
		System.out.println(ret);
	}
	
	class P implements Comparable<P> {
		int x;
		int y;
		int val;
		public P(int y, int x, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(P o) {
			return this.val - o.val;
		}
	}
}
