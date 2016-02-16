/*
 * @(#)Problem11052.java $version 2016. 2. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11052 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem11052().run();
	}
	
	int n;
	int[] p;
	int[] cache;
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = new int[n]; cache = new int[n+1];
		for(int i=0;i<n;i++) p[i] = Integer.valueOf(st.nextToken());
		
		for(int i=1;i<=n;i++){
			for(int j=0;j<i;j++){
				cache[i] = Math.max(cache[i], cache[i-j-1]+p[j]);
			}
		}
		System.out.println(cache[n]);
	}
}
