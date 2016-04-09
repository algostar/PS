/*
 * @(#)Problem10815_YG.java $version 2016. 4. 5.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10815_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem10815_YG().run();
	}
	
	int n;
	int[] a;
	int m;
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.valueOf(br.readLine());
		a=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			a[i]=Integer.valueOf(st.nextToken());
		}
		m=Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		st=new StringTokenizer(br.readLine());
		Arrays.sort(a);
		for(int i=0;i<m;i++){
			sb.append(have(Integer.valueOf(st.nextToken()))).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	public String have(int k){
		int s=0;
		int e=n-1;
		
		while(s<=e){
			int mid=(s+e)/2;
			if(a[mid]<k){
				s=mid+1;
			}else if(k<a[mid]){
				e=mid-1;
			}else{
				return "1";
			}
		}
		return "0";
	}
}
