package seattle.algostar.ps.acmicpc.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2470_JW {
	public static void main(String[] args) {
		new Problem2470_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		long[] A = new long[nn];
		for(int i = 0; i < nn; i++) A[i] = sc.nextLong();
		Arrays.sort(A);
		
		long[] res = new long[2];
		res[0] = A[0]; res[1] = A[1];
		for (int i = 0; i < nn-1; i++) {
			// lower_bound
			int s = i+1, e = nn-1;
			while (s < e) {
				int m = (s + e + 1) / 2;
				if (0 < A[i] + A[m]) {
					e = m - 1;
				} else {
					s = m;
				}
			}
			setP(res, A[i], A[s]);
			// upper_bound
			s = i+1; e = nn-1;
			while (s < e) {
				int m = (s + e - 1) / 2;
				if (0 <= A[i] + A[m]) {
					e = m;
				} else {
					s = m + 1;
				}
			}
			setP(res, A[i], A[s]);
		}
		System.out.println(res[0] + " " + res[1]);
	}

	private void setP(long[] P, long cv, long sv) {
		if (Math.abs(cv + sv) < Math.abs(P[0] + P[1])) {
			P[0] = cv; P[1] = sv;
		}
	}
}
