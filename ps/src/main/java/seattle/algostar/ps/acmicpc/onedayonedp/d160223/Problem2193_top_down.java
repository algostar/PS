/*
 * @(#)Problem2193_top_down.java $version 2016. 3. 2.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.util.Scanner;

public class Problem2193_top_down {
	public static void main(String[] args){
		new Problem2193_top_down().run();
	}
	
	int n;
	long[][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		cache= new long[n+1][2];
		
		cache[1][1]=1;
		for(int i=2;i<=n;i++){
			cache[i][0]+=cache[i-1][1];
			cache[i][0]+=cache[i-1][0];
			cache[i][1]+=cache[i-1][0];
		}
		System.out.println(cache[n][0]+cache[n][1]);
	}
}
