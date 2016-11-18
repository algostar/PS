package seattle.algostar.ps.leetcode;

import java.math.BigInteger;

public class Problem67_JW {
	public static void main(String[] args) {
		new Problem67_JW().solve();
	}

	private void solve() {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println(addBinary(a, b));;
	}
	
    public String addBinary(String a, String b) {
    	BigInteger ba = new BigInteger(a, 2);
    	BigInteger bb = new BigInteger(b, 2);
        return ba.add(bb).toString(2);
    }
}
