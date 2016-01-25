package seattle.algostar.ps.acmicpc.library.code;


public class BitTest {
	public static void main(String[] args) {
		new BitTest().run();
	}

	private void run() {

		int bit = 0;
		
		// bit on
		bit = bit | (1 << 3);
		System.out.println(bit);
		
		// bit check
		System.out.println( (bit & (1 << 3)) != 0 );
		
		// bit off
		bit = bit - (1 << 3);
		System.out.println(bit);
		
		
	}
}
