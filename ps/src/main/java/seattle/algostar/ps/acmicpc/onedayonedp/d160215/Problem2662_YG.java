/*
 * @(#)Problem2662_YG.java $version 2016. 2. 19.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160215;

import java.util.Scanner;

public class Problem2662_YG {
	public static void main(String[] args){
		new Problem2662_YG().run();
	}
	
	int k;
	int n;
	int[][] cost;
	int[][] cache;
	int[][] path;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt(); n = sc.nextInt();
		cost = new int[n+1][k+1];
		cache = new int[n+1][k+1];
		path = new int[n+1][k+1];
		
		for(int i=0;i<k;i++){
			int invest = sc.nextInt();
			for(int j=0;j<n;j++){
				cost[j+1][invest] = sc.nextInt();
			}
		}
		for(int i=1;i<=n;i++){
			for(int j=0;j<=k;j++){
				int rst = cache[i][j];
				for(int t=0;t<=j;t++){
					if(rst < cache[i-1][j-t] + cost[i][t]){
						rst = cache[i-1][j-t] + cost[i][t];
						path[i][j] = t;
					}
				}
				cache[i][j] = rst;
			}
		}
		
		System.out.println(cache[n][k]);
		re(n,k);
	}
	
	public void re(int index, int v){
		if(index == 0) return;
		re(index-1,v - path[index][v]);
		System.out.print(path[index][v] + " ");
	}
}
