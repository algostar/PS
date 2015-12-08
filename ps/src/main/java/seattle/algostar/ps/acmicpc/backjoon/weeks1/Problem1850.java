/*
 * @(#)Problem1850.java $version 2015. 12. 8.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.io.IOException;
import java.util.Scanner;

public class Problem1850 {
	public static void main(String[] args) throws IOException{
		new Problem1850().run();
	}
	
	public void run() throws IOException{
		Scanner sc = new Scanner(System.in);
		long a = Long.valueOf(sc.next()); long b = Long.valueOf(sc.next());
		long gcd = gcd(a,b);
		for(long i =0; i<gcd; i++){
			System.out.print("1");
		}
	}
	
	public long gcd(long a, long b){
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
