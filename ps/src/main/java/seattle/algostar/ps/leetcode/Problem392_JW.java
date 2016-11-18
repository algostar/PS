package seattle.algostar.ps.leetcode;

public class Problem392_JW {
	public static void main(String[] args) {
		new Problem392_JW().solve();
	}

	private void solve() {
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("axc", "ahbgdc"));
		System.out.println(isSubsequence("", "ahbgdc"));
		System.out.println();
		System.out.println(isSubsequence2("abc", "ahbgdc"));
		System.out.println(isSubsequence2("axc", "ahbgdc"));
		System.out.println(isSubsequence2("", "ahbgdc"));
	}
	
	
    public boolean isSubsequence(String s, String t) {
    	if (s.length() == 0 || t.length() == 0) return false;
    	
    	int ix = 0;
    	for (int i = 0; i < t.length(); i++) {
    		if (s.charAt(ix) == t.charAt(i)) {
    			ix++;
    		}
    	}
    	if (ix == s.length()) return true;
    	return false;
    }
    
    public boolean isSubsequence1(String s, String t) {
    	s = " " + s;
    	t = " " + t;
    	char[] A = s.toCharArray();
    	char[] B = t.toCharArray();
    	
    	int n = A.length;
    	int m = B.length;
    	
    	int[][] cache = new int[2][m];
    	
    	int max = 0;
    	for (int i = 1; i < n; i++) {
    		for (int j = 1; j < m; j++) {
    			if (A[i] == B[j]) {
    				cache[i%2][j] = cache[(i-1)%2][j-1] + 1;
    			} else {
    				cache[i%2][j] = Math.max(cache[i%2][j-1], cache[(i-1)%2][j]);
    			}
    			max = Math.max(max, cache[i%2][j]);
    		}
    	}
    	
    	return max == s.length() - 1;
    }
    
    public boolean isSubsequence2(String s, String t) {
    	s = " " + s;
    	t = " " + t;
    	char[] A = s.toCharArray();
    	char[] B = t.toCharArray();
    	
    	int n = A.length;
    	int m = B.length;
    	
    	int[] cache = new int[m];
    	
    	int max = 0;
    	for (int i = 1; i < n; i++) {
    		for (int j = m-1; j > 0; j--) {
    			if (A[i] == B[j]) {
    				cache[j] = Math.max(cache[j], cache[j-1] + 1);
    			} else {
    				cache[j] = Math.max(cache[j-1], cache[j]);
    			}
    			max = Math.max(max, cache[j]);
    		}
    	}
    	
    	return max == s.length() - 1;
    }
}
