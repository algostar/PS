package seattle.algostar.ps.leetcode;

import java.util.Stack;

public class Problem394_JW {
	public static void main(String[] args) {
		new Problem394_JW().solve();
	}

	private void solve() {
		String s = "3[a]2[bc]";
		System.out.println(decodeString(s));;
	}

	private String decodeString(String s) {
		
		return getStr(0, s.toCharArray());
	}

	private String getStr(int i, char[] chars) {
		
		if (i == chars.length) return "";
		
		String num = "";
		while ( Character.isDigit(chars[i]) ) {
			num += chars[i];
			i++;
		}
		int nn = Integer.parseInt(num);
		
		while ( chars[i] != ']' ) {
			
		}
		
		String str = getStr(i + 1, chars);
		String ret = "";
		for (int cnt = 0; cnt < nn; cnt++) {
			ret += str;
		}
		
		return ret;
	}
	
//    public String decodeString(String s) {
//    	Stack<Character> stk = new Stack<Character>();
//    	
//    	StringBuilder res = new StringBuilder();
//    	StringBuilder sub = new StringBuilder();
//    	for (int i = 0; i < s.length(); i++) {
//    		char ch = s.charAt(i);
//    		if (ch != ']') {
//    			stk.add(ch);
//    		} else {
//    			char c;
//    			while ( (c = stk.pop()) != '[' ) {
//    				sub.append(c);
//    			}
//    			
//    			String num = "";
//    			while ( !stk.isEmpty() && Character.isDigit( (c = stk.peek()) ) ) {
//    				c = stk.pop();
//    				num = c + num;
//    			} 
//    			int n = Integer.parseInt(num);
//    			
//    			StringBuilder su = new StringBuilder(); 
//    			for (int cnt = 0; cnt < n; cnt++) {
//    				su.append(res);
//    			}
//    			sub = su;
//    		}
//    	}
//    	
//    	return res.reverse().toString();
//    }
}

