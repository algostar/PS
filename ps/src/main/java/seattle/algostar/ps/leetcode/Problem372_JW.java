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
		int a = 2;
	    int[] b = {3};
		System.out.println(superPow(a, b));
	}
	
	public int superPow(int a, int[] b) {
		String num = "";
		for (int n : b) {num = num + n;}
		
		BigInteger biA = new BigInteger(String.valueOf(a));
		BigInteger biB = new BigInteger(num); 
		
    	return pow(biA, biB).intValue();
    }
	
	Map<String, BigInteger> cache = new HashMap<String, BigInteger>();
	
	BigInteger biMod = new BigInteger("1337");
	BigInteger bi2 = new BigInteger("2");
	
	private BigInteger pow(BigInteger a, BigInteger b) {
		if (cache.containsKey(b.toString())) {
			return cache.get(b.toString());
		}
		
		if (b.equals(BigInteger.ZERO)) return BigInteger.ONE;
		if (b.equals(BigInteger.ONE)) return a;
		
		if (b.mod(bi2) == BigInteger.ZERO) {
			BigInteger res = pow(a, b.divide(bi2)).multiply(pow(a, b.divide(bi2))).mod(biMod);
			cache.put(b.toString(), res);
			return res;
		} else {
			BigInteger res = pow(a, b.divide(bi2)).multiply(pow(a, b.divide(bi2).add(BigInteger.ONE))).mod(biMod);
			cache.put(b.toString(), res);
			return res;
		}
	}
}
