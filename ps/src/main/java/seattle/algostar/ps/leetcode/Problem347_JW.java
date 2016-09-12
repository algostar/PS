package seattle.algostar.ps.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem347_JW {
	public static void main(String[] args) {
		new Problem347_JW().solve();
	}

	private void solve() {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		System.out.println(topKFrequent(nums, k));;
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> cnts = new HashMap<>();
    	for (int n : nums) {
    		if (cnts.containsKey(n)) {
    			cnts.put(n, cnts.get(n) + 1);
    		} else {
    			cnts.put(n, 1);
    		}
    	}
    	
    	List<Entry<Integer, Integer>> lst = new ArrayList<>(cnts.entrySet());
    	
    	Collections.sort(lst, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
    	});
    	
    	List<Integer> res = new ArrayList<Integer>();
    	int cnt = 0;
    	for (int i = lst.size()-1; i >= 0 && cnt < k; i--, cnt++) {
    		res.add(lst.get(i).getKey());
    	}
    	
    	return res;
    }
}
