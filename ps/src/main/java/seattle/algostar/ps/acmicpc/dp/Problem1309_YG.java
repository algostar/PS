/*
 * @(#)Problem1309.java $version 2015. 10. 30.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.naver.shopping.codingPractice.dp;

import java.util.Scanner;

public class Problem1309 {
	public static void main(String[] args){
		new Problem1309().run();
	}
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] cache = new int[n+2][3];
		
		cache[1][0] = 1; cache[1][1] = 1; cache[1][2] = 1;
		for(int i = 2; i <= n+1; i++){
			cache[i][0] = (cache[i-1][0] + cache[i-1][1] + cache[i-1][2]) % 9901;
			cache[i][1] = (cache[i-1][2] + cache[i-1][0]) % 9901;
			cache[i][2] = (cache[i-1][1] + cache[i-1][0]) % 9901;
		}
		
		System.out.println((cache[n+1][0]) % 9901);
	}
}
