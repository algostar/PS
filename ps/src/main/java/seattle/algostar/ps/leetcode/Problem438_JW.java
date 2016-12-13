package seattle.algostar.ps.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Problem438_JW {
	public static void main(String[] args) {
		new Problem438_JW().solve();
	}

	private void solve() {
		
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}

    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> res = new ArrayList<Integer>();
    	
    	int[] pCnt = new int[27];
    	int[] sCnt = new int[27];
    	
    	for (int i = 0; i < p.length(); i++) {
    		int ix = p.charAt(i) - 'a';
    		pCnt[ix]++;
    	}
    	
    	int cnt = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (i > p.length() - 1 && cnt == p.length()) {
    			int bix = i - p.length();
    			int ix = s.charAt(bix) - 'a';
    			sCnt[ix]--;
    			ix = s.charAt(i) - 'a';
    			sCnt[ix]++;
    		} else {
    			int ix = s.charAt(i) - 'a';
    			sCnt[ix]++;
    			cnt++;
    		}
    		
    		if (isSame(pCnt, sCnt)) {
    			res.add(i-p.length()+1);
    		}
    	}
    	
        return res;
    }
    
	
    private boolean isSame(int[] pCnt, int[] sCnt) {
		for (int i = 0; i < 26; i++) {
			if (pCnt[i] != sCnt[i]) return false;
		}
		return true;
	}

	public List<Integer> findAnagrams1(String s, String p) {
    	List<Integer> res = new ArrayList<Integer>();
    	int len = p.length();
    	char[] ps = p.toCharArray();
    	Arrays.sort(ps);
    		
    	for (int six = 0; six <= s.length() - len; six++) {
    		int eix = six + len;
    		
    		char[] chs = s.toCharArray();
    		Arrays.sort(chs, six, eix);
    		
    		boolean isSame = true;
    		for (int j = 0; j < len; j++) {
    			if (chs[six + j] != ps[j]) {
    				isSame = false;
    			}
    		}
    		
    		if (isSame) res.add(six);
    	}
    	
        return res;
    }
}
