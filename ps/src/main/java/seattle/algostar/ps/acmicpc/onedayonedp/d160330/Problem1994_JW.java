package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.*;

public class Problem1994_JW {
	public static void main(String[] args) {
		new Problem1994_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int[] V = new int[nn];
		for (int i = 0; i < nn; i++) {
			V[i] = sc.nextInt();
		}
		
		Arrays.sort(V);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nn; i++) {
			map.put(V[i], i);
		}
		
		int[][] F = new int[nn][nn];
		for (int i = 0; i < nn; i++) Arrays.fill(F[i], 2);
		
		int max = 1;
		for (int i = 1; i < nn; i++) {
			for (int j = i - 1; j >= 0; j--) {
				int d = V[i] - V[j];
				if (d == 0) {
					F[j][i] = i - j + 1;
					max = Math.max(max, F[j][i]);
					continue;
				}
				
				if (map.containsKey(V[j] - d)) {
					int k = map.get(V[j] - d);
					
					if (k < j) {
						F[j][i] = F[k][j] + 1;
					}
					
					max = Math.max(max, F[j][i]);
				}
			}
		}
		System.out.println(max);
	}
}
