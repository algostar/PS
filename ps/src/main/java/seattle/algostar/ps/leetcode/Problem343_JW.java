package seattle.algostar.ps.leetcode;

public class Problem343_JW {
	public static void main(String[] args) {
		new Problem343_JW().solve();
	}

	private void solve() {
		System.out.println(integerBreak(2));
		System.out.println(integerBreak(3));
		System.out.println(integerBreak(4));
		System.out.println(integerBreak(5));
	}
	
    public int integerBreak(int n) {
        int[] DP = new int[n+1];
        DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
            	int res = Math.max(j, DP[j]) * Math.max( (i-j), DP[i-j] );  
            	DP[i] = Math.max(DP[i], res);
            }
        }
        return DP[n];
    }
}
