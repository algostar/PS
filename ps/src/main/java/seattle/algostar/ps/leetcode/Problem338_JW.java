package seattle.algostar.ps.leetcode;

public class Problem338_JW {
	public static void main(String[] args) {
		new Problem338_JW().solve();
	}

	private void solve() {
		
	}
	
    public int[] countBits(int num) {
    	int[] A = new int[num+1];
    	for (int i = 0; i < num; i++) {
    		A[i] = Integer.bitCount(i);
    	}
        return A;
    }
}
