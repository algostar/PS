/*
 * @(#)Problem11004_YG.java $version 2015. 12. 19.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem11004_YG {
	public static void main(String[] args) throws IOException{
		//new Problem11004_YG().run();
	}
	
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] f = br.readLine().split(" ");
		String[] s = br.readLine().split(" ");
		int n = Integer.valueOf(f[0]); int k =Integer.valueOf(f[1]);
		int[] it = new int[n];
		for(int i=0;i<n;i++){
			it[i] = Integer.valueOf(s[i]);
		}
		Arrays.sort(it);
		System.out.println(it[k-1]);
	}
}
