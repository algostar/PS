/*
 * @(#)Problem2157_YG.java $version 2016. 3. 23.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2157_YG {
	public static void main(String[] args) throws IOException{
		new Problem2157_YG().run();
	}
	
	int[][] invertg;
	int[][] cache;
	int n,m,s;
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.valueOf(st.nextToken());
		m=Integer.valueOf(st.nextToken());
		s=Integer.valueOf(st.nextToken());
		invertg = new int[n+1][n+1];
		cache=new int[n+1][m+1];
		for(int i=0;i<n;i++){
			Arrays.fill(cache[i], Integer.MIN_VALUE);
		}
		for(int i=0;i<s;i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			
			invertg[to][from]=Math.max(invertg[to][from], cost);
		}
		int rst=0;
		cache[1][1]=0;
		for(int i=2;i<=n;i++){
			for(int j=1;j<=m;j++){
				for(int k=1;k<i;k++){
					if(invertg[i][k]!=0){
						cache[i][j] = Math.max(cache[i][j], cache[k][j-1]+invertg[i][k]);
					}
				}
				if(i==n) rst=Math.max(rst, cache[i][j]);
			}
		}
		System.out.println(rst);
	}
}
