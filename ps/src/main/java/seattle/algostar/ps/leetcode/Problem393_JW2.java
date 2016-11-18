package seattle.algostar.ps.leetcode;

public class Problem393_JW2 {
	public static void main(String[] args) {
		new Problem393_JW2().solve(); 
	}

	
	private void solve() {
//		int[] data = {197, 130, 1};
//		int[] data = {235, 140, 4};
		int[] data = {240,162,138,147,145};
		System.out.println(validUtf8(data));;
	}
	
	public boolean validUtf8(int[] data) {
        int ix = 0;
        while (ix < data.length) {
            String bit = getBit(data, ix);
            if (bit.startsWith("0")) {ix++; continue;}
            
            int n = getN(bit);
            if (n <= 0) return false;
            else {
                int lastIx = ix;
                for (ix = ix + 1; ix <= lastIx + n && ix < data.length; ix++) {
                    bit = getBit(data, ix);
                    if (!bit.startsWith("10")) return false;
                }
                if (ix <= lastIx + n) return false;
            }
        }
        return true;
    }
    
    private int getN(String bit) {
        int cnt = 0;
        for (int i = 0; i < bit.length(); i++) {
            if (bit.charAt(i) == '1') cnt++;
            else return cnt-1;
        }
        return -1;
    }
    
    String[] zeros = {"", "0", "00", "000", "0000", "00000", "000000", "0000000"};
    private String getBit(int[] data, int ix) {
        String bit = Integer.toBinaryString(data[ix]);
        int r = 8 - bit.length();
        bit = zeros[r] + bit;
        return bit;
    }
}
