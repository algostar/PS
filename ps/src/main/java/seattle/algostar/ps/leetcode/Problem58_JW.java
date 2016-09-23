package seattle.algostar.ps.leetcode;

public class Problem58_JW {
	public static void main(String[] args) {
		new Problem58_JW().solve();
	}

	private void solve() {
		System.out.println(lengthOfLastWord("123 444 "));;
	}
	
    public int lengthOfLastWord(String s) {
        int len = 0;
        String ss = s.trim();
        if (ss.length() == 0) return 0;
        for (int i = ss.length() - 1; i >= 0; i--) {
            if (ss.charAt(i) != ' ') len++;
            else break;
        }
        return len;
    }
}
