package seattle.algostar.ps.acmicpc.temp;

import java.util.BitSet;

public class BitTest {
	public static void main(String[] args) {
		new BitTest().run();
	}

	private void run() {
		BitSet bs = new BitSet();
		bs.set(0);
		bs.set(1);
		bs.set(1);
		System.out.println(bs.length());
		
		
		int a = 0;
		System.out.println(a);
		a |= (1 << 0);
		System.out.println(a);
		for (int i = 0; i <= 9;i++) {
			a |= (1 << i);
		}
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a);
	}
}
