/*
 * @(#)Problem9327_YG_2.java $version 2016. 4. 5.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem9327_YG_2 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem9327_YG_2().run();
	}
	
	int[][] cache;
	int n;
	int e;
	int[] a;
	int[] psum;
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases=Integer.valueOf(br.readLine());
		while(cases-- >0){
			String[] is = br.readLine().split(" ");
			n=Integer.valueOf(is[0]);
			e=Integer.valueOf(is[1]);
			a=new int[n+1];
			psum=new int[n+1];
			
			int sum=0;
			StringTokenizer st =  new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++){
				a[i]=Integer.valueOf(st.nextToken());
				sum+=a[i];
				psum[i]+=sum;
			}
			cache = new int[n+1][sum+1];
			for(int i=0;i<=n;i++) Arrays.fill(cache[i], 987654321);
			
			int rst=f(1,0);

			if(rst==987654321){
				bw.write("FULL");
			}else{
				bw.write(String.valueOf(rst));
			}
			bw.newLine();
		}
		bw.flush();
	}
	
	public int f(int i, int s){
		if(2*s>=e) return 0;
		if(i>n) return 987654321;
		//if(2*(s+psum[n]-psum[i-1])<e) return 987654321;
		
		if(cache[i][s]!=987654321){
			return cache[i][s];
		}	
		return cache[i][s]=Math.min(f(i+1,s), f(i+1,s+a[i])+a[i]);
	}
}
