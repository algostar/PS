/*
 * @(#)Problem1904.java $version 2015. 11. 22.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.naver.shopping.codingPractice.dp;

import java.util.Scanner;

public class Problem1904_YG {
	public static void main(String[] args){
		new Problem1904_YGProblem1904_YGProblem1904_YG().run();
	}
	
	int n;
	int[] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cache = new int[n + 1];
		
		cache[1] = 1; cache[2] = 2;
		
		for(int i = 3; i <= n; i++){
			cache[i] = (cache[i -1] + cache[i-2]) % 15746;
		}
		
		System.out.println(cache[n]);
	}
}
