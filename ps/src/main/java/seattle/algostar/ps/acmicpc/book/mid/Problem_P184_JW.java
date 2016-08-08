package seattle.algostar.ps.acmicpc.book.mid;

import java.util.Scanner;

public class Problem_P184_JW {
	public static void main(String[] args) {
		new Problem_P184_JW().solve();
	}

	int m, n;
	int[] A;
	private void solve() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		getCount(0, 0);
		
		
		System.out.println(minCnt);
		System.out.println(vCnt);
		
		vCnt = 0;
		minCnt = Integer.MAX_VALUE;
		
		getCount2(0, 0, 0);
		System.out.println(minCnt);
		System.out.println(vCnt);
	}
	
	private void getCount2(int ix, int moneyCnt, int moneyValue) {
		vCnt++;
		if (ix > n - 1) return ;
		
		if (minCnt <= moneyCnt) return ;
		if (moneyValue > m) return ;
		
		if (moneyValue == m) {
			minCnt = Math.min(minCnt, moneyCnt);
			return ;
		}
		
		for (int cnt = 0; moneyValue + A[ix]*cnt <= m; cnt++) {
			getCount2(ix + 1, moneyCnt + cnt, moneyValue + A[ix]*cnt);
		}
	}

	int minCnt = Integer.MAX_VALUE;

	int vCnt = 0;
	
	private void getCount(int moneyCnt, int moneyValue) {
		vCnt++;
		if (minCnt <= moneyCnt) return ;
		if (moneyValue > m) return;
		
		if (moneyValue == m) {
			minCnt = Math.min(minCnt, moneyCnt);
			return ;
		}
		
		for (int i = 0; i < n; i++) {
			getCount(moneyCnt + 1, moneyValue + A[i]);
		}
	}
}

