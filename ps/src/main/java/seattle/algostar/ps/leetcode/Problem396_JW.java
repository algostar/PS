package seattle.algostar.ps.leetcode;

public class Problem396_JW {


	public static void main(String[] args) {
		new Problem396_JW().solve();
	}

	private void solve() {
		int[] A = {4,3,2,6};
		System.out.println(maxRotateFunction(A));
	}
	
	
    public int maxRotateFunction(int[] A) {
    	int max = Integer.MIN_VALUE;
    	int n = A.length;
    	for (int s = 0; s < n; s++) {
    		int sum = 0;
    		for (int i = s, cnt = 0; cnt < n; i++, cnt++) {
    			int ix = i % n;
    			sum += cnt * A[ix];
    		}
    		max = Math.max(max, sum);
    	}
    	return max;
    }
}
