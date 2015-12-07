/*
 * @(#)Problem11720_YG.java $version 2015. 12. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem11720_YG {
	public static void main(String[] args){
		new Problem11720_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] in = sc.next().toCharArray();
		
		int sum =0;
		for(int i=0;i<n;i++){
			sum+=in[i] - '0';
		}
		System.out.println(sum);
	}
}
