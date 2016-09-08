package seattle.algostar.ps.acmicpc.algorithm.binarysearch;

import junit.framework.Assert;

import org.junit.Test;

public class UpperBound {
	public static void main(String[] args) {
		new UpperBound().solve();
	}

	@Test
	public void solve() {
		int[] A = {3, 5};
		Assert.assertEquals(0, upperBound(1, A));
		Assert.assertEquals(0, upperBound(2, A));
		Assert.assertEquals(1, upperBound(3, A));
		Assert.assertEquals(1, upperBound(4, A));
		Assert.assertEquals(1, upperBound(5, A));
		Assert.assertEquals(1, upperBound(6, A));
		
		int[] B = {3, 4, 5};
		Assert.assertEquals(0, upperBound(1, B));
		Assert.assertEquals(0, upperBound(2, B));
		Assert.assertEquals(1, upperBound(3, B));
		Assert.assertEquals(2, upperBound(4, B));
		Assert.assertEquals(2, upperBound(5, B));
		Assert.assertEquals(2, upperBound(6, B));
	}
	
	public int upperBound(int val, int[] A) {
		int s = 0, e = A.length-1;
		while (s < e) {
			int m = (s + e) / 2;
			if (A[m] <= val) {
				s = m + 1;
			} else {
				e = m;
			}
		}
		return e;
	}
}
