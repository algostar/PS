package seattle.algostar.ps.leetcode;

import java.util.Arrays;

public class Problem376_JW {
	public static void main(String[] args) {
		new Problem376_JW().solve();
	}

	private void solve() {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		System.out.println(wiggleMaxLength(nums));
	}

	int POSITIVE = 0;
	int NEGATIIVE = 1;
    public int wiggleMaxLength(int[] nums) {
    	int nn = nums.length;
    	if (nn <= 1) return nn;
    	
    	int[][] DP =  new int[nn][2];
    	
    	for (int[] D : DP) Arrays.fill(D, 1);
    	
    	int maxLen = 1;
    	for (int i = 0; i < nn; i++) {
    		for (int j = 0; j < i; j++) {
    			if (nums[i] > nums[j]) {
    				DP[i][POSITIVE] = Math.max(DP[i][POSITIVE], DP[j][NEGATIIVE] + 1);
    			}
    			if (nums[i] < nums[j]) {
    				DP[i][NEGATIIVE] = Math.max(DP[i][NEGATIIVE], DP[j][POSITIVE] + 1);
    			}
    			maxLen = Math.max(maxLen, DP[i][POSITIVE]);
    			maxLen = Math.max(maxLen, DP[i][NEGATIIVE]);
    		}
    	}
		return maxLen;
    }
}
