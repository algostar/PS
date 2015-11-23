/*
 * @(#)Problem8394.java $version 2015. 11. 21.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.naver.shopping.codingPractice.dp;

import java.util.Scanner;

public class Problem8394_YG {
	public static void main(String[] args){
		new Problem8394_YG().run();
	}
	
	int n;
	int[] dp;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dp = new int[n + 1];
		
		if(n <= 2){
			System.out.println(2);
		}else{
			dp[1] = 1; dp[2] = 2;
			
			for(int i = 3; i <= n; i++){
				dp[i] = (dp[i-1] + dp[i-2]) % 10;
			}
			
			System.out.println(dp[n]);
		}
	}
}
