package seattle.algostar.ps.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem390_JW {
	public static void main(String[] args) {
		new Problem390_JW().solve();
	}

	private void solve() {
		System.out.println(lastRemaining(1000));
	}
	
    public int lastRemaining(int n) {
    	Integer[] A = new Integer[n];
    	for (int i = 1; i <=n; i++) {A[i-1] = i;}
    	
    	int direct = 1;
    	
    	while (A.length != 1) {
    		A = getA(direct, A);
    		direct = -direct;
    	}
    	
    	return A[0];
    }

	private Integer[] getA(int direct, Integer[] A) {
		List<Integer> lst = new ArrayList<Integer>();

		if (A.length % 2 != 0) {
			for (int i = 1; i < A.length; i += 2) {
				lst.add(A[i]);
			}
		} else {
			int start = (direct == 1) ? 1 : 0;
			for (int i = start; i < A.length; i += 2) {
				lst.add(A[i]);
			}
		}
		
		return lst.toArray(new Integer[0]);
	}
}
