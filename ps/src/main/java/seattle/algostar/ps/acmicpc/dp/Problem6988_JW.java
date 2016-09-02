package seattle.algostar.ps.acmicpc.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem6988_JW {
	public static void main(String[] args) {
		new Problem6988_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		long[] A = new long[nn];
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		for (int i = 0; i < nn; i++) {
			A[i] = sc.nextInt();
			map.put(A[i], i);
		}
		
		long max = 0;
		long[][] DP = new long[nn][nn];
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < i; j++) {
				long diff = A[i] - A[j];
				if (map.containsKey(A[j] - diff)) {
					int k = map.get(A[j] - diff);
					if (DP[j][k] > 0) {
						DP[i][j] = A[i] + DP[j][k];
					} else {
						DP[i][j] = A[i] + A[j] + A[k];
					}
					
					max = Math.max(max, DP[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}
