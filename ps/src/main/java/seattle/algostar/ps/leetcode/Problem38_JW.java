package seattle.algostar.ps.leetcode;

public class Problem38_JW {
	public static void main(String[] args) {
		new Problem38_JW().solve();
	}

	private void solve() {
		for (int i = 1; i < 20; i++) {
			System.out.println(countAndSay(i));
			System.out.println();
		}
	}
	
    public String countAndSay(int n) {
        String[] A = new String[n+2];
        A[1] = "1"; A[2] = "11";
        for (int i = 3; i <= n; i++) {
            A[i] = getStr(i, A);   
        }
        return A[n];
    }
    
    private String getStr(int i, String[] A) {
        String res = "";
        String prevStr = A[i-1];
        char last = prevStr.charAt(0); int cnt = 1;
        for (int j = 1; j < prevStr.length(); j++) {
            char cur = prevStr.charAt(j);
            if (last == cur) {cnt++;}
            else {res += (cnt+""+last); last = cur; cnt = 1;}
        }
        res += (cnt + "" + last);
        return res;
    }
}

