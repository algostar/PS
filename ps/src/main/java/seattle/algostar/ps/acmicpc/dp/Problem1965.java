/*
 * @(#)Problem1965.java $version 2015. 11. 23.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1965 {
	public static void main(String[] args){
		new Problem1965().run();
	}
	
	int n;
	int[] a;
	int[] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n+1];
		cache = new int[n+1];
		
		for(int i =1; i <=n;i++){
			a[i] = sc.nextInt();
		}
		cache[1] = 1;
		
		for(int i = 2; i <= n; i++){
			int max = 1;
			for(int j = 1; j < i; j++){
				if(a[i] > a[j]) max = Math.max(max, cache[j] + 1);
			}
			cache[i] = max;
		}
		
		int rst = -1;
		
		for(int i = 1; i <=n ;i++){
			rst = Math.max(rst, cache[i]);
		}
		
		System.out.println(rst);
	}
}
