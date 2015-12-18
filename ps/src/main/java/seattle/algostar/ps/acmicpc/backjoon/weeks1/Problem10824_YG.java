/*
 * @(#)Problem10824_YG.java $version 2015. 12. 17.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem10824_YG {
	public static void main(String[] args){
		new Problem10824_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		String a = sc.next(); String b = sc.next();
		String c = sc.next(); String d = sc.next();
		long l =0; long r =0; int base=1;
		for(int i=0;i<b.length();i++){
			base *= 10;
		}
		l = Long.valueOf(a) * base + Long.valueOf(b); base=1;
		for(int i=0;i<d.length();i++){
			base *= 10;
		}
		r = Long.valueOf(c) * base + Long.valueOf(d);
		System.out.println(l+r);
	}
}
