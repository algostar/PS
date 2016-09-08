package seattle.algostar.ps.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Problem354_JW3 {
	public static void main(String[] args) {
		new Problem354_JW3().solve();
	}

	private void solve() {
//		int[][] envelopes = {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
		int[][] envelopes = {{5,4},{6,7},{6,8},{2,3}};
		System.out.println(maxEnvelopes(envelopes));
	}
	
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int res = o1[0] - o2[0];
				if (res == 0) {
					return o2[1] - o1[1];
				} else {
					return res;
				}
			}});
        
        int nn = envelopes.length;
        int[] DP = new int[nn];
        Arrays.fill(DP, 1);
        int len = 0;
        for (int i = 0; i < nn; i++) {
        	
        	int s = 0, e = len;
        	while ( s < e ) {
        		int m = (s + e) / 2;
        		if (DP[m] < envelopes[i][1]) {
        			s = m + 1;
        		} else {
        			e = m;
        		}
        	}
        	
        	DP[e] = envelopes[i][1];
        	if (e == len) {
        		len++;
        	}
        }
        return len;
    }
}
