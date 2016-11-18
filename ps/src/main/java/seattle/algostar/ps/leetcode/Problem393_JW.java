package seattle.algostar.ps.leetcode;

public class Problem393_JW {
	public static void main(String[] args) {
		new Problem393_JW().solve(); 
	}

	
	private void solve() {
//		int[] data = {197, 130, 1};
//		int[] data = {235, 140, 4};
		int[] data = {237};
		System.out.println(validUtf8(data));;
	}
	
	String[] ZEROS = {"", "0", "00", "000", "0000", "00000", "000000", "0000000"};
	String[] BIT = {"0", "110", "1110", "11110"};
	
    public boolean validUtf8(int[] data) {
    	int ix = 0;
		while (ix < data.length) {
			String bit = getBit(data, ix);
			int n = getNBytesChar(bit);
			if (n == -1) {
				return false;
			} else {
				for (int cnt = 1; cnt <= n; cnt++) {
					ix++;
					if (ix == data.length) return false;
					bit = getBit(data, ix);
					if (!bit.startsWith("10")) return false;
				}
			}
			ix++;
		}
		return true;
    }


	private String getBit(int[] data, int ix) {
		String bit = Integer.toBinaryString(data[ix]);
		int rest = 8 - bit.length();
		bit = ZEROS[rest] + bit;
		return bit;
	}
    
	private int getNBytesChar(String bits) {
		for (int i = 0; i < BIT.length; i++) {
			if (bits.startsWith(BIT[i])) return i;
		}
		return -1;
	}
}
