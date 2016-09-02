package seattle.algostar.ps.acmicpc.book.mid;

import java.util.Scanner;

public class Problem_P190_JW {
	public static void main(String[] args) {
		new Problem_P190_JW().solve();
	}

	int[] A;
	int bb, nn;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		bb = sc.nextInt();
		nn = sc.nextInt();
		A = new int[nn];
		for (int i = 0; i < nn; i++) A[i] = sc.nextInt();
		
		f(0, 0);
		System.out.println(max);
		System.out.println(cnt);
		
		max = 0;
		f2(-1, 0);
		System.out.println(max);
		System.out.println(cnt);
	}

	private void f2(int ix, int sum) {
		cnt++;
		
		if (sum > bb) return;
		
		if (sum <= bb) {
			max = Math.max(max, sum);
		}
		
		for (int i = ix + 1; i < nn-1; i++) {
			f(i, sum + A[i]);
		}
	}

	int max = 0;
	
	int cnt = 0;
	
	private void f(int ix, int sum) {
		cnt++;
		
		if (ix > nn - 1) return;
		
		if (sum <= bb) {
			max = Math.max(max, sum);
		}
		
		f(ix + 1, sum + A[ix]);
		f(ix + 1, sum);
	}
}
