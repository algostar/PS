package seattle.algostar.ps.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Problem354_JW2 {
	public static void main(String[] args) {
		new Problem354_JW2().solve();
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
        	int ix = Arrays.binarySearch(DP, 0, len, envelopes[i][1]); 
        	if (ix < 0) {
        		ix = - (ix + 1);
        	}
        	DP[ix] = envelopes[i][1];
        	if (ix == len) {
        		len++;
        	}
        }
        return len;
    }
}
