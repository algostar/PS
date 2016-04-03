/*
 * @(#)Problem2854_YG.java $version 2016. 3. 31.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2854_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem2854_YG().run();
	}
	
	int n;
	int[] a;
	int[] b;
	long[][] cache;
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		a = new int[n+1];
		b=new int[n+1];
		cache=new long[n+1][2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer stt = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++){
			a[i]=Integer.valueOf(st.nextToken());
			if(i!=1) b[i]=Integer.valueOf(stt.nextToken());
		}
	
		cache[0][0]=1;
		for(int i=1;i<=n;i++){
			cache[i][0]+=cache[i-1][0]*(a[i]+b[i])+cache[i-1][1]*(a[i]+b[i]-1);
			cache[i][0]%=1000000007;
			if(i==n) continue;
			cache[i][1]+=cache[i-1][0]*b[i+1];
			cache[i][1]%=1000000007;
			cache[i][1]+=cache[i-1][1]*b[i+1];
			cache[i][1]%=1000000007;
		}
		
		System.out.println(cache[n][0]+cache[n][1]);
	}
}
