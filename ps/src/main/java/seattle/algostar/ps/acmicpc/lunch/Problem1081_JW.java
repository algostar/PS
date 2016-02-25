package seattle.algostar.ps.acmicpc.lunch;

import java.util.Scanner;

public class Problem1081_JW {
	public static void main(String[] args) {
		new Problem1081_JW().solve();
	}

	private void solve() {
		long[] C = new long[10];
		for (int i = 1; i <= 9; i++) {
			C[i] = (long) (C[i-1] * 10 + (45 * Math.pow(10, i-1)));
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		int a = Math.max(sc.nextInt() - 1, 0);
		int b = sc.nextInt();
		
		long sa = getSum(a, C);
		long sb = getSum(b, C);
		
		System.out.println(sb - sa);
	}

	private long getSum(long num, long[] C) {
		long sum = 0; 
		String S = String.valueOf(num);
		for (int i = 0; i < S.length(); i++) {
			int first = S.charAt(i) - '0';
			int rest = S.length()-1 - i;
			sum += first * C[rest];
			
			if (rest != 0) {
				for (int j = 1; j <= first; j++) {
					if (j == first) {
						long cnt = first * (Long.valueOf( S.substring(i + 1) ) + 1);
						sum += cnt;
					} else {
						sum += j * Math.pow(10, rest);
					}
				}
			} else {
				sum += first*(first+1)/2;
			}
		}
		return sum;
	}
}
