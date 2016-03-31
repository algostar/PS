/*
 * @(#)Problem2159_YG.java $version 2016. 3. 27.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2159_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem2159_YG().run();
	}
	
	int[] ax;
	int[] ay;
	int[] dx={0,-1,1,0,0};
	int[] dy={0,0,0,-1,1};
	long[][] cache;
	int n;
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.valueOf(br.readLine());
		
		ax=new int[n+1]; ay=new int[n+1];
		cache = new long[n+1][5];
		for(int i=0;i<=n;i++){
			String[] in = br.readLine().split(" ");
			ax[i]=Integer.valueOf(in[0]);
			ay[i]=Integer.valueOf(in[1]);
		}
		
		for(int i=0;i<=n;i++){
			Arrays.fill(cache[i], 9999999999999L);
		}
		cache[0][0]=0;
		long rst=9999999999999L;
		for(int i=1;i<=n;i++){
			int prevX=ax[i-1];
			int prevY=ay[i-1];
			for(int j=0;j<5;j++){
				int nowX=ax[i]+dx[j];
				int nowY=ay[i]+dy[j];
				
				for(int k=0;k<5;k++){
					int prevXX = prevX+dx[k];
					int prevYY = prevY+dy[k];
					cache[i][j]=Math.min(cache[i][j], cache[i-1][k]+Math.abs(nowX-prevXX)+Math.abs(nowY-prevYY));
				}
				if(i==n) rst=Math.min(rst, cache[i][j]);
			}
		}
		System.out.println(rst);
	}
}
