package seattle.algostar.ps.acmicpc.dp;

import org.junit.Test;

public class Problem1947_JWTest {
	int n;
	int[] A;
	boolean[] used;
	@Test
	public void test() {
		n = 6;
		A = new int[n];
		used = new boolean[n];
		for (int i = 0; i < n; i++) {
			A[i] = i;
		}
		
		f(0, "");
	}
	private void f(int step, String path) {
		if (step == n) {
			System.out.println(path);
			return;
		}
		
		for (int ix = 0; ix < n; ix++) {
			if (!used[ix] && step != ix) {
				used[ix] = true;
				f(step+1, path + (ix+1));
				used[ix] = false;
			}
		}
	}
}
