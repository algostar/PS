package seattle.algostar.ps.acmicpc.temp;

import java.util.BitSet;

public class BitTest {
	public static void main(String[] args) {
		//new BitTest().run();
		
//		int base=1;
//		for(base=1;base<5;base*=2);
//		System.out.println(base);
		int a=10,b=14;
		for(;a<b;){
			if(a%2==1) a++;
			if(b%2==0) b--;
			a>>=1; b>>=1;
			System.out.print(a + " " +b );
			System.out.println();
		}
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
