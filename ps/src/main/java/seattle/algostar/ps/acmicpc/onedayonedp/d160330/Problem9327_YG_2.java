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
		new Problem9327_YG().run();
	}
	
	int[][] cache;
	int n;
	int e;
	int[] a;
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases=Integer.valueOf(br.readLine());
		while(cases-- >0){
			String[] is = br.readLine().split(" ");
			n=Integer.valueOf(is[0]);
			e=Integer.valueOf(is[1]);
			a=new int[n+1];
			
			int sum=0;
			StringTokenizer st =  new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++){
				a[i]=Integer.valueOf(st.nextToken());
				sum+=a[i];
			}
			cache = new int[n+1][sum+1];
			for(int i=0;i<=n;i++) Arrays.fill(cache, -1);
			f(n, sum);
			
			int rst=-1;
			for(int i=0;i<=sum;i++){
				if(cache[n][i]==1 && 2*i>=e){
					rst=i;
					break;
				}
			}
			
			if(rst==-1){
				bw.write("FULL");
			}else{
				bw.write(String.valueOf(rst));
			}
			bw.newLine();
		}
		bw.flush();
	}
	
	public int f(int i, int s){
		if(s==0) return 1;
		if(i<0 || s<0) return 0;
		
		if(cache[i][s]==-1){
			return cache[i][s];
		}	
		return cache[i][s]=f(i-1,s)|f(i-1,s-a[i]);
	}
}
