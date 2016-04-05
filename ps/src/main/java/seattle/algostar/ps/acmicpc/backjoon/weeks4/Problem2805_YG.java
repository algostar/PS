/*
 * @(#)Problem2805_YG.java $version 2016. 4. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2805_YG {
	public static void main(String[] args) throws IOException{
		new Problem2805_YG().run();
	}
	
	int n;
	int m;
	long[] a;
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		
		n=Integer.valueOf(in[0]);
		m=Integer.valueOf(in[1]);
		StringTokenizer st = new StringTokenizer(br.readLine());
		a= new long[n];
		for(int i=0;i<n;i++){
			a[i]=Integer.valueOf(st.nextToken());
		}
		int s=1000000000;
		int e=0;
		while(e<s){
			int mid=(s+e+1)/2;
			if(m<=this.getH(mid)){
				e=mid;
			}else{
				s=mid-1;
			}
		}
		System.out.println(e);
	}
	
	public long getH(int h){
		long rst=0;
		for(int i=0;i<n;i++){
			long r = a[i]-h;
			if(r>0)rst+=r;
		}
		return rst;
	}
}
