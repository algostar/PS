package seattle.algostar.ps.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Problem347_JW2 {
	public static void main(String[] args) {
		new Problem347_JW2().solve();
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
    	
    	PriorityQueue<Entry<Integer, Integer>> pque = new PriorityQueue<Entry<Integer, Integer>>(new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
    	
    	pque.addAll(cnts.entrySet());
    	
    	List<Integer> res = new ArrayList<Integer>();
    	for (int cnt = 0; cnt < k; cnt++) {
    		res.add(pque.poll().getKey());
    	}
    	
    	return res;
    }
}
