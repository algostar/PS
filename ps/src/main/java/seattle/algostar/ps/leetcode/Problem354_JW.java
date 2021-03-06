package seattle.algostar.ps.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Problem354_JW {
	public static void main(String[] args) {
		new Problem354_JW().solve();
	}

	private void solve() {
		int[][] envelopes = {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
		System.out.println(maxEnvelopes(envelopes));
	}
	
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int res = o1[0] - o2[0];
				if (res == 0) {
					return o1[1] - o2[1];
				} else {
					return res;
				}
			}});
        
        int max = 0;
        int nn = envelopes.length;
        int[] DP = new int[nn];
        Arrays.fill(DP, 1);
        for (int i = 0; i < nn; i++) {
        	for (int k = 0; k <= i; k++) {
        		if (isPossOverlap(envelopes[k], envelopes[i])) {
        			DP[i] = Math.max(DP[i], DP[k] + 1);
        		}
        		max = Math.max(max, DP[i]);
        	}
        }
        return max;
    }

	private boolean isPossOverlap(int[] en1, int[] en2) {
		if (en1[0] < en2[0] && en1[1] < en2[1]) {
			return true;
		} else {
			return false;
		}
	}
}
