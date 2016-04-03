/*
 * @(#)Problem6988_YG.java $version 2016. 1. 8.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.study.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem6988_YG {
	public static void main(String[] args){
		new Problem6988_YG().run();
	}
	
	int[][] dp;
	int n;
	int[] a;
	Map<Integer,Integer> m;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		dp = new int[n][n]; m = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
			m.put(a[i], i);
		}
		int max = 0;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(m.containsKey(a[j]-a[i]+a[j])){
					dp[i][j] = a[i] + a[j];
				}
			}
		}
		
		for(int i=2;i<=n;i++){
			for(int j=1;j<n;j++){
				if(m.containsKey(a[j]-a[i]+a[j])){
					int v = m.get(a[j]-a[i]+a[j]);
					dp[j][v] = Math.max(dp[j][v], dp[i][j] + a[v]);
					max = Math.max(dp[j][v], max);
				}
			}
		}
		System.out.println(max);
	}
}
