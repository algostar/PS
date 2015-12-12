/*
 * @(#)Problem11005.java $version 2015. 12. 8.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem11005_YG {
	public static void main(String[] args){
		new Problem11005_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int b = sc.nextInt();
		String rst = "";
		while(n != 0){
			int mod = n - (n / b) * b;
			n = n / b;
			
			if(mod >=10){
				rst = (char)(mod-10 + 'A') + rst;
			}else{
				rst = mod + rst;
			}
		}
		System.out.println(rst);
	}
}
