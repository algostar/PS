package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2157_JW {
	public static void main(String[] args) {
		new Problem2157_JW().solve(); 
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int mm = sc.nextInt();
		int kk = sc.nextInt();
		
		Path[] paths = new Path[kk];
		
		int[][] DT = new int[nn+1][mm+1];
		for (int i = 0; i <= nn; i++) Arrays.fill(DT[i], Integer.MIN_VALUE);
		
		int startIx = 0;
		for (int i = 0; i < kk; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
			
			if (s >= e) {
				v = Integer.MIN_VALUE;
			}
			
			paths[i] = new Path(s, e, v);
		}
		Arrays.sort(paths);
		
		for (int i = 0; i < kk; i++) {
			int s = paths[i].s;
			int e = paths[i].e;
			int v = paths[i].v;
			if (s == 1) {
				DT[e][1] = Math.max(DT[e][1], v);
			} else {
				for (int j = 2; j <= mm; j++) {
					if (DT[s][j-1] != Integer.MIN_VALUE) {
						DT[e][j] = Math.max(DT[e][j], DT[s][j-1] + v); 
					}
				}
			}
		}
		
		int max = 0;
		for (int j = 1; j <= mm; j++) {
			max = Math.max(max, DT[nn][j]);
		}
		System.out.println(max);
	}
	
	class Path implements Comparable<Path> {
		int s;
		int e;
		int v;
		public Path(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
		@Override
		public int compareTo(Path o) {
			int r = this.s - o.s;
			if (r == 0) {
				r = this.e - o.e;
			}
			if (r == 0) {
				r = o.v - this.v;
			}
			return r;
		}
	}
}
