/*
 * @(#)Problem9327_YG.java $version 2016. 4. 1.
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
import java.util.StringTokenizer;

public class Problem9327_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem9327_YG().run();
	}
	
	boolean[][] cache;
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
			cache = new boolean[n+1][200001];
			
			int sum=0;
			StringTokenizer st =  new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++){
				a[i]=Integer.valueOf(st.nextToken());
				sum+=a[i];
			}
			cache[0][0]=true;
			for(int i=1;i<=n;i++){
				for(int j=0;j<=sum;j++){
					cache[i][j]=cache[i-1][j];
					if(j-a[i]>=0) cache[i][j]|=cache[i-1][j-a[i]];
				}
			}
			
			int rst=-1;
			for(int i=0;i<=sum;i++){
				if(cache[n][i] && 2*i>=e){
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
}
