package seattle.algostar.ps.acmicpc.onedayonedp.d160323;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10272_JW {
	public static void main(String[] args) {
		new Problem10272_JW().solve(); 
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for (int t = 0; t < tt; t++) {
			int nn = sc.nextInt();
			Point[] points = new Point[nn];
			for (int i = 0; i < nn; i++) {
				points[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(points);
			
			double[][][] SS = new double[nn][nn][nn];
			for (int i = 0; i < nn; i++) {
				for (int left = 0; left < nn; left++) {
					for (int right = nn-1; right >= 0; right--) {
						double val1 = SS[i][left][right] + getDist(left, i, points);
						SS[i+1][i][right] = Math.min(SS[i+1][i][right], val1);
						
						double val2 = SS[i][left][right] + getDist(right, i, points);
						SS[i+1][left][i] = Math.min(SS[i+1][left][i], val2);
					}
				}
			}
			System.out.println(SS[nn-1][nn-1][0]);
		}
	}
	
	private double getDist(int a, int b, Point[] points) {
		double x = Math.pow(points[a].x - points[b].x, 2);
		double y = Math.pow(points[a].y - points[b].y, 2);
		return Math.sqrt(x + y);
	}

	class Point implements Comparable<Point> {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			return this.x - o.x;
		}
	}
}
