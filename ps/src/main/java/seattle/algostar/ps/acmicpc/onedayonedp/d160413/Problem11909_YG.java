/*
 * @(#)Problem11909_YG.java $version 2016. 4. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11909_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem11909_YG().run();
	}
	
	int n;
	int[][] a;
	int[][] cache;

	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.valueOf(br.readLine());
		a=new int[n+1][n+1]; cache=new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++){
				a[i][j]=Integer.valueOf(st.nextToken());
			}
			Arrays.fill(cache[i], 987654321);
		}
		Arrays.fill(cache[0], 987654321);
		
		cache[1][1]=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i>1){
					int dist = a[i][j]-a[i-1][j]>=0?a[i][j]-a[i-1][j]+1:0;
					cache[i][j]=Math.min(cache[i][j], cache[i-1][j]+dist);
				}
				
				if(j>1){
					int dist = a[i][j]-a[i][j-1]>=0?a[i][j]-a[i][j-1]+1:0;
					cache[i][j]=Math.min(cache[i][j], cache[i][j-1]+dist);
				}
			}
		}
		
		System.out.println(cache[n][n]);
	}
}
