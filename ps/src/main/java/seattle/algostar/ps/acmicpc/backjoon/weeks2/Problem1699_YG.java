/*
 * @(#)Problem1699_YG.java $version 2016. 2. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.util.Scanner;

public class Problem1699_YG {
	public static void main(String[] args){
		new Problem1699_YG().run();
	}
	
	int n;
	int[] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cache = new int[n+1];
		for(int i=1;i<=n;i++){
			int rst = 987654322;
			for(int j=1;j*j<=i;j++){
				rst = Math.min(rst, cache[i-j*j]+1);
				cache[i] = rst;
			}
		}
		System.out.println(cache[n]);
	}
}
