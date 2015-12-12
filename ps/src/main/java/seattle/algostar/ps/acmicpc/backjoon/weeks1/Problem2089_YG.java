/*
 * @(#)Problem2089_YG.java $version 2015. 12. 12.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem2089_YG {
	public static void main(String[] args){
		new Problem2089_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int n = s;
		String rst = "";
		
		while(n != 0){
			int mod = 0;
			if(n>=0){
				mod = n - (n/2) * 2;
				n = -(n/2);
			}else{
				mod = n - ((int)Math.ceil(Math.abs(n) / 2d)) * -2;
				n = (int)Math.ceil(Math.abs(n) / 2d);
			}
			rst = mod + rst;
		}
		
		System.out.println(s == 0 ? "0" : rst);
	}
}
