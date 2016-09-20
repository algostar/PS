package seattle.algostar.ps.leetcode;

import java.util.Arrays;

public class Problem6_JW {
	public static void main(String[] args) {
		new Problem6_JW().solve();
	}

	private void solve() {
		System.out.println(convert("AB", 1));
	}
	
	public String convert(String s, int numRows) {
		if (s.length() <= 1 || numRows <= 1) return s;
		
		String[] A = new String[numRows];
		Arrays.fill(A, "");
		A[0] = "" + s.charAt(0);
		
		int dir = 1; int step = 1; int ix = 1;
		for (int i = 1; i < s.length(); i++) {
			A[ix] += s.charAt(i);
			
			if (step == numRows-1) {step = 1; dir *= -1;}
			else {step++;}
			
			ix += dir;
		}
		
		String res = "";
		for (String a : A) {
			res += a;
		}
		return res;
	}
}
