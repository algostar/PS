/*
 * @(#)Problem2342_YG.java $version 2016. 2. 17.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2342_YG {
	public static void main(String[] args) throws IOException{
		new Problem2342_YG().run();
	}
	
	
	int[][][] cache;
	int[] a = new int[100000];
	int n=0;
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(true){
			int t = Integer.valueOf(st.nextToken());
			if( t == 0 ) break;
			a[n] = t;
			n++;
		}
		cache = new int[n+1][5][5];
		for(int i=0;i<=n;i++){
			for(int j=0;j<5;j++){
				Arrays.fill(cache[i][j], 987654321);
			}
		}
		cache[0][0][0] =0;
		
		for(int i=0;i<n;i++){
			for(int l=0;l<5;l++){
				for(int r=0;r<5;r++){
					if(i!=0 && l==r) continue;
					int to = a[i];
					if(to != r){
						cache[i+1][to][r] = Math.min(cache[i+1][to][r], cache[i][l][r] + score(l,to));
					}
					
					if(to != l){
						cache[i+1][l][to] = Math.min(cache[i+1][l][to], cache[i][l][r] + score(r, to));
					}
				}
			}
		}
		
		int rst = 987654321;
		for(int i=0;i<5;i++){
			rst = Math.min(rst, Math.min(cache[n][i][a[n-1]], cache[n][a[n-1]][i]));
		}
		System.out.println(rst);
	}
	
	public int score(int from, int to){
		if(from == to) return 1;
		if(from == 0) return 2;
		if(from + to == 6 || from + to == 4){
			return 4;
		}else{
			return 3;
		}
	}
}
