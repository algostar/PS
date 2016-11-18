package seattle.algostar.ps.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem260_JW {
	public static void main(String[] args) {
		new Problem260_JW().solve();
	}

	private void solve() {
		
	}
	
    public int[] singleNumber(int[] nums) {
    	Map<Integer, Boolean> hash = new HashMap<>();
    	
    	for (int n : nums) {
    		if (hash.containsKey(n)) {
    			hash.remove(n);
    		} else {
    			hash.put(n, true);
    		}
    	}
    	
    	Integer[] r = hash.keySet().toArray(new Integer[0]);
    	int[] res = new int[2];
    	res[0] = r[0];
    	res[1] = r[1];
    	return res;
    }
}
