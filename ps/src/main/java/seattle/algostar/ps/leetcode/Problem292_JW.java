package seattle.algostar.ps.leetcode;

public class Problem292_JW {
	public static void main(String[] args) {
		new Problem292_JW().solve();
	}

	private void solve() {
		System.out.println(canWinNim(5));
	}
	
    public boolean canWinNim(int n) {
    	if (n <= 0) return false;
    	if (n <= 3) return true;
    	
    	boolean win = true;
    	
    	for (int i = 2; i <= 6; i++) {
    		boolean w = canWinNim(n - i);
    		if (!w) win = false;
    	}
    	
    	return win;
    }
}
