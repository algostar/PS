/*
 * @(#)Problem11721.java $version 2015. 12. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem11721_YG {
	public static void main(String[] args){
		new Problem11721_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		int startIndex =0;
		while(startIndex < in.length()){
			System.out.println(in.substring(startIndex, startIndex+10 <= in.length() ? startIndex+10 : in.length()));
			startIndex +=10;
		}
	}
}
