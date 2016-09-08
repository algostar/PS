package seattle.algostar.ps.leetcode;

public class Problem375_JW {
	public static void main(String[] args) {
		new Problem375_JW().solve();
	}

	private void solve() {
		System.out.println(getMoneyAmount(5));
	}
	
    public int getMoneyAmount(int n) {
    	int[][] DP = new int[n+1][n+1];
    	
    	for (int e = 1; e <= n; e++) {
    		for (int s = e - 1; s >= 1; s--) {
    			int max = 0;
    			int min = Integer.MAX_VALUE;
    			for (int p = s + 1; p < e ; p++) {
    				max = p + Math.max(DP[s][p-1], DP[p+1][e]);
    				min = Math.min(min, max);
    			}
    			DP[s][e] = e - s == 1 ? s : min;
    		}
    	}
    	
        return DP[1][n];
    }
}
