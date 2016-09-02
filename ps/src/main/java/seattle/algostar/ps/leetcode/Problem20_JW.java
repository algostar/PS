package seattle.algostar.ps.leetcode;

import java.util.Stack;

public class Problem20_JW {
	public static void main(String[] args) {
		new Problem20_JW().solve();
	}

	private void solve() {
		System.out.println(isValid("("));
	}
	
	public boolean isValid(String s) {
		String open = "({[";
		String close = ")}]";
		
		Stack<Character> stk = new Stack<Character>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			int idx = close.indexOf(String.valueOf(ch[i]));
			if (idx < 0) {
				stk.add(ch[i]);
			} else {
				if (stk.isEmpty()) return false;
				if (stk.pop() != open.charAt(idx)) {
					return false;
				}
			}
			
		}
		
		if (stk.size() > 0) return false;
		
		return true;
	}
}
