/*
 * @(#)Problem10872_YG.java $version 2015. 12. 14.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem10872_YG {
	public static void main(String[] args){
		new Problem10872_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rst = 1;
		for(int i=1;i<=n;i++){
			rst *= i;
		}
		
		System.out.println(rst);
	}
}
