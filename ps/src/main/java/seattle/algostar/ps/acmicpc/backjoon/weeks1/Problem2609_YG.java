/*
 * @(#)Problem2609.java $version 2015. 12. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem2609_YG {
	public static void main(String[] args){
		new Problem2609_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); int b = sc.nextInt();
		System.out.println(gcd(a,b));
		System.out.println(a*b/gcd(a,b));
	}
	
	public int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
