/*
 * @(#)Problem1912_YG.java $version 2016. 2. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1912_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem1912_YG().run();
	}
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cache = new int[n+1];
		int max =Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			if(cache[i-1] > 0){
				cache[i] = cache[i-1] + Integer.valueOf(st.nextToken());
			}else{
				cache[i] = Integer.valueOf(st.nextToken());
			}		
			max = Math.max(max, cache[i]);
		}
		System.out.println(max);
	}
}
