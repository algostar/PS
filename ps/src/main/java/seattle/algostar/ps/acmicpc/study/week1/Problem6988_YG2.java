/*
 * @(#)Problem6988_YG2.java $version 2016. 3. 24.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.study.week1;

import java.util.Scanner;

public class Problem6988_YG2 {
	public static void main(String[] args){
		new Problem6988_YG2().run();
	}
	
	int[][] cache;
	int n;
	int[] a;
	int[] ae;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n+1];
		ae = new int[10000001];
		cache = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++){
			int v=sc.nextInt();
			a[i]=v;
			ae[v]=i;
		}
		
		int rst=0;
		for(int i=3;i<=n;i++){
			for(int j=2;j<i;j++){
				int prev = a[j]-(a[i]-a[j]);
				if(prev>0 && ae[prev]!=0){
					cache[i][j] = Math.max(cache[j][ae[prev]]+a[i], a[ae[prev]]+a[j]+a[i]);
					rst=Math.max(rst, cache[i][j]);
				}
			}
		}
		System.out.println(rst);
	}
}
