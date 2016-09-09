package seattle.algostar.ps.leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem372_JW {
	public static void main(String[] args) {
		new Problem372_JW().solve();
	}

	private void solve() {
//		int a = 2147483647;
//	    int[] b = {2, 0, 0};
	    
	    int a = 9;
	    int[] b = {3, 3, 5};
		System.out.println(superPow(a, b));
		System.out.println(test(a, b));
	}
	
	public int test(int a, int[] b) {
	    String num = "";
        for (int n : b) {num = num + n;}
        
        BigInteger biA = new BigInteger(String.valueOf(a));
        BigInteger biB = new BigInteger(num); 
        BigInteger biMod = new BigInteger("1337");
        
        return biA.modPow(biB, biMod).intValue();
	}
	
	int MOD = 1337;
	
	public int superPow(int a, int[] b) {

		int nn = b.length;
		long[] D = new long[nn];
		
		D[nn-1] = a % MOD;
		for (int i = nn-2; i >= 0; i--) {
			D[i] = (long)(Math.pow(D[i+1], 10) % MOD);
		}
		
		long res = 1;
		for (int i = nn-1; i >= 0; i--) {
			res *= getValue(b[i], D[i]);
			res %= MOD;
		}
		
		return (int)res;
    }

	private long getValue(int cnt, long value) {
		long ret = 1;
		for (int c = 1; c <= cnt; c++) {
			ret *= value;
			ret %= MOD;
		}
		return ret;
	}
	
}
