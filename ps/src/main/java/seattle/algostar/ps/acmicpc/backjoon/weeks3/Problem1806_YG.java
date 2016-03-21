/*
 * @(#)Problem1806_YG.java $version 2016. 3. 8.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1806_YG {
	public static void main(String[] args) throws IOException{
		new Problem1806_YG().run();
	}
	
	int n;
	int[] a;
	int s;
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		n=Integer.valueOf(in[0]); s=Integer.valueOf(in[1]);
		in = br.readLine().split(" ");
		a= new int[n+1];
		for(int i=1;i<=n;i++){
			a[i]=Integer.valueOf(in[i-1]);
		}
		int tail=0; int psum=0; int rst=Integer.MAX_VALUE;
		for(int i=1;i<=n;i++){
			psum+=a[i];
			while(psum>=s){
				rst = Math.min(rst, i-tail);
				tail++;
				psum-=a[tail];
			}
		}
		System.out.println(rst==Integer.MAX_VALUE?0:rst);
	}
}
