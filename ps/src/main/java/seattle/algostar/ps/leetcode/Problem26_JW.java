package seattle.algostar.ps.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem26_JW {
	public static void main(String[] args) {
		new Problem26_JW().solve();
	}

	private void solve() {
		
	}
	
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int nn = nums.length;
        int prev = nums[0];
        int nlen = 1;
        
        int[] res = nums;
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(prev);
        for (int i = 1; i < nn; i++) {
            int curr = nums[i];
            if (prev != curr) {
            	nlen++;
            	lst.add(curr);
            }
            prev = curr;
        }
        
        int sz = lst.size();
        for (int i = 0; i < sz; i++) {
        	res[i] = lst.get(i);
        }
        
        return nlen;
    }
}
