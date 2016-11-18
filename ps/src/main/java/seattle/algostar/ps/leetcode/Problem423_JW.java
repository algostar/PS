package seattle.algostar.ps.leetcode;

import java.util.Arrays;

public class Problem423_JW {
	public static void main(String[] args) {
		new Problem423_JW().solve();
	}

	private void solve() {
		System.out.println(originalDigits("owoztneoer"));
	}
	
	String[] dstr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
    public String originalDigits(String s) {
    	
    	int[] alpha = new int[27];
    	for (int i = 0; i < s.length(); i++) {
    		alpha[s.charAt(i) - 'a']++;
    	}
    	
    	int[] cnt = new int[10];
    	// 1.
    	if (alpha[ix('z')] > 0) {
    		
    		dec(0, alpha, cnt);
    		int c = alpha[ix('z')];
    		cnt[0] = c;
    		
    		alpha[ix('z')] = 0;
    		alpha[ix('e')] -= c;
    		alpha[ix('r')] -= c;
    		alpha[ix('o')] -= c;
    	}
    	if (alpha[ix('w')] > 0) {
    		
    		int c = alpha[ix('w')];
    		cnt[2] = c;
    		
    		alpha[ix('w')] = 0;
    		alpha[ix('t')] -= c;
    		alpha[ix('o')] -= c;
    	}
    	if (alpha[ix('g')] > 0) {
    		cnt[8] = alpha['g' - 'a']; alpha['g' - 'a'] = 0;
    		
    		int c = alpha[ix('g')];
    		cnt[2] = c;
    		
    		alpha[ix('w')] = 0;
    		alpha[ix('t')] -= c;
    		alpha[ix('o')] -= c;
    	}
    	if (alpha['x' - 'a'] > 0) {cnt[6] = alpha['x' - 'a']; alpha['x' - 'a'] = 0;}
    	// 2.
    	if (alpha['t' - 'a'] > 0) {cnt[3] = alpha['t' - 'a']; alpha['t' - 'a'] = 0;}
    	// 3.
    	if (alpha['u' - 'a'] > 0) {cnt[4] = alpha['u' - 'a']; alpha['u' - 'a'] = 0;}
    	// 4.
    	if (alpha['f' - 'a'] > 0) {cnt[5] = alpha['f' - 'a']; alpha['f' - 'a'] = 0;}
    	// 5.
    	if (alpha['s' - 'a'] > 0) {cnt[7] = alpha['s' - 'a']; alpha['s' - 'a'] = 0;}
    	// 6.
    	if (alpha['o' - 'a'] > 0) {cnt[1] = alpha['o' - 'a']; alpha['o' - 'a'] = 0;}
    	// 7
    	if (alpha['i' - 'a'] > 0) {cnt[9] = alpha['i' - 'a']; alpha['i' - 'a'] = 0;}
    	
    	String res = "";
    	for (int i = 0; i < 10; i++) {
    		
    		char[] digit = new char[cnt[i]];
    		Arrays.fill(digit, (char)(i + '0'));
    		res += String.valueOf(digit);
    	}
    	
    	return res;
    }
    
    private void dec(int num, int[] alpha, int[] cnt) {
		int c = alpha[ix('z')];
		cnt[0] = c;
		
		alpha[ix('z')] = 0;
		alpha[ix('e')] -= c;
		alpha[ix('r')] -= c;
		alpha[ix('o')] -= c;
	}

	private int ix(char ch) {
    	return ch - 'a';
    }
}
