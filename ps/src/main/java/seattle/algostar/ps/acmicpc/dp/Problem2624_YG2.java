/*
 * @(#)Problem2624_YG2.java $version 2016. 3. 21.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2624_YG2 {
	public static void main(String[] args){
		new Problem2624_YG().run();
	}
	
	int[][][] cache;
	int s;
	int n;
	int[] coin;
	int[] coinc;
	public void run(){
		Scanner sc = new Scanner(System.in);
		s =sc.nextInt();
		n=sc.nextInt();
		cache=new int[n+1][s+1][1001];
		coin = new int[n+1];
		coinc = new int[n+1];
		for(int i=1;i<=n;i++){
			coin[i]=sc.nextInt(); coinc[i]=sc.nextInt();
		}
		cache[0][0][0]=1;
		for(int i=1;i<=n;i++){
			for(int j=0;j<=s;j++){
				for(int k=1;k<=coinc[i];k++){
					for(int r=0;r<=coinc[i-1];r++){
						cache[i][j][k]+=cache[i-1][j][k];
					}
					if(j-coin[i]>=0) cache[i][j][k]=cache[i][j-coin[i]][k-1];
				}
			}
		}
		System.out.println(cache[s][coinc[n]]);
	}
}
