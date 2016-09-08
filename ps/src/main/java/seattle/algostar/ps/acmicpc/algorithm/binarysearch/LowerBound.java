package seattle.algostar.ps.acmicpc.algorithm.binarysearch;

import junit.framework.Assert;

import org.junit.Test;

public class LowerBound {
	public static void main(String[] args) {
		new LowerBound().solve();
	}

	@Test
	public void solve() {
		int[] A = {3, 5};
		Assert.assertEquals(0, lowerBound(1, A));
		Assert.assertEquals(0, lowerBound(2, A));
		Assert.assertEquals(0, lowerBound(3, A));
		Assert.assertEquals(1, lowerBound(4, A));
		Assert.assertEquals(1, lowerBound(5, A));
		Assert.assertEquals(1, lowerBound(6, A));
		
		int[] B = {3, 4, 5};
		Assert.assertEquals(0, lowerBound(1, B));
		Assert.assertEquals(0, lowerBound(2, B));
		Assert.assertEquals(0, lowerBound(3, B));
		Assert.assertEquals(1, lowerBound(4, B));
		Assert.assertEquals(2, lowerBound(5, B));
		Assert.assertEquals(2, lowerBound(6, B));
	}
	
	public int lowerBound(int val, int[] A) {
		int s = 0, e = A.length-1;
		while (s < e) {
			int m = (s + e) / 2;
			if (A[m] < val) {
				s = m + 1;
			} else {
				e = m;
			}
		}
		return e;
	}
}
