/*
 * @(#)Problem2515_YG.java $version 2016. 2. 24.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2515_YG {
	public static void main(String[] args) throws IOException{
		new Problem2515_YG().run();
	}
	
	pic[] p;
	int[] cache;
	int[] idx;
	int[] max;
	int n, s;
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		n=Integer.valueOf(in[0]); s=Integer.valueOf(in[1]);
		
		cache=new int[n+1]; p=new pic[n+1]; idx = new int[n+1]; max = new int[n+1];
		for(int i=0;i<n;i++){
			in = br.readLine().split(" ");
			p[i] = new pic(Integer.valueOf(in[0]),Integer.valueOf(in[1]));
		}
		p[n]=new pic(0,0);
		Arrays.sort(p);
		cache[1]=p[1].w; max[1]=p[1].w;
		for(int i=2;i<=n;i++){
			int prev=idx[i-1];
			for(int j=idx[i-1]+1;j<i;j++){
				if(p[i].h - p[j].h < s){
					prev=j-1;
					break;
				}
				prev=j;
			}
			idx[i]=prev;
			cache[i] = cache[idx[i]]+p[i].w;
			cache[i] = Math.max(cache[i-1], cache[i]);
		}
		System.out.println(cache[n]);
	}
	
	class pic implements Comparable<pic>{
		int h;
		int w;
		
		public pic(int h, int w){
			this.h=h; this.w=w;
		}
		@Override
		public int compareTo(pic o) {
			return this.h-o.h;
		}
		
	}
}
