package seattle.algostar.ps.acmicpc.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1654_JW {
	public static void main(String[] args) {
		new Problem1654_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int kk = sc.nextInt();
		
		long[] A = new long[nn];
		for (int i = 0; i < nn; i++) A[i] = sc.nextInt();
		Arrays.sort(A);
		
		long s = 1, e = A[A.length-1];
		while (e - s > 0) {
			long m = (s + e)/2;
			long cnt = getSpritCnt(m, A);
			if (cnt < kk) {
				e = m - 1;
			} else if (cnt >= kk) {
				s = m + 1;
			}
		}
		System.out.println(s-1);
	}

	private long getSpritCnt(long m, long[] A) {
		int cnt = 0;
		for (long l : A) {
			cnt += (l / m);
		}
		return cnt;
	}
}
