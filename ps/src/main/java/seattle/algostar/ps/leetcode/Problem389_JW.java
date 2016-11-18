package seattle.algostar.ps.leetcode;

public class Problem389_JW {
	public static void main(String[] args) {
		new Problem389_JW().solve();
	}

	private void solve() {
		int a = 1;
		System.out.println(a);
		a ^= 1;
		System.out.println(a);
		a ^= 1;
		System.out.println(a);
		a ^= 1;
		System.out.println(a);
		
//		System.out.println(findTheDifference("abc", "abcd"));
	}

	public char findTheDifference(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		char t1 = 0;
		for (char c1 : sArray)
			t1 ^= c1;
		for (char c2 : tArray)
			t1 ^= c2;
		return (char)t1;
	}
}
