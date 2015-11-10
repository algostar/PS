/*
 * @(#)Problem10844.java $version 2015. 11. 9.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem10844_YG {
	public static void main(String[] args){
		new Problem10844_YG().run();
	}
	
	int n; int[][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		cache = new int[n + 1][10];
		
		for(int i = 1; i <=9; i++){
			cache[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i ++){
			for(int k = 0; k <= 9; k++){
				int left = k == 0 ? 0 : cache[i - 1][k-1];
				int right = k == 9 ? 0 : cache[i-1][k+1];
				cache[i][k] = (left + right) % 1000000000;
				
			}
		}
		
		int rst = 0;
		for(int i = 0; i <= 9 ; i++){
			rst =(rst + cache[n][i]) % 1000000000;
		}
		
		System.out.println(rst);
	}
}
