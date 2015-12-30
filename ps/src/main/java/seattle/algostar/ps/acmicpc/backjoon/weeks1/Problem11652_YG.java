/*
 * @(#)Problem11652_YG.java $version 2015. 12. 19.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem11652_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem11652_YG().run();
	}
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.valueOf(br.readLine());
		long[] l = new long[n+1];
		for(int i=0;i<n;i++){
			l[i] = Long.valueOf(br.readLine());
		}
		l[n]= Long.MAX_VALUE;
		Arrays.sort(l);
		long now = l[0]; int cnt=1; int max=1;
		for(int i=1;i<=n;i++){
			if(l[i]!=l[i-1]){
				if(max<cnt){
					max = cnt;
					now=l[i-1];
				}
				cnt=1;
			}else{
				cnt++;
			}
		}
		
		System.out.println(now);
	}
}
