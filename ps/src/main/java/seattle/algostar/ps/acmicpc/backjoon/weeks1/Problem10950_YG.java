/*
 * @(#)Problem10950_YG.java $version 2015. 12. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem10950_YG {
	public static void main(String[] args){
		new Problem10950_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0;i<n;i++){
			System.out.println(sc.nextInt() + sc.nextInt());
		}
	}
}
