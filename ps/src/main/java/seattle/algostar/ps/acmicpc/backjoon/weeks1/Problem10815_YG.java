/*
 * @(#)Problem10814.java $version 2015. 12. 18.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem10815_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem10815_YG().run();
	}
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		List<Mem> ml = new ArrayList<Mem>();
		for(int i=0;i<n;i++){
			String[] in = br.readLine().split(" ");
			ml.add(new Mem(in[0], Integer.valueOf(in[1]), Integer.valueOf(in[2]), Integer.valueOf(in[3])));
		}
		Collections.sort(ml);
		for(int i=0;i<n;i++){
			bw.write(ml.get(i).na);
			bw.newLine();
		}
		bw.close();
	}
	
	class Mem implements Comparable<Mem>{
		String na; int g; int e; int m;
		public Mem(String na, int g, int e, int m){
			this.na=na; this.g=g; this.e=e; this.m=m;
		}
		/**
		 * @param o
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Mem o) {
			if(this.g<o.g){
				return 1;
			}else if(this.g == o.g){
				if(this.e>o.e){
					return 1;
				}else if(this.e == o.e){
					if(this.m < o.m){
						return 1;
					}else if(this.m == o.m){
						return this.na.compareTo(o.na);
					}
				}
			}
			
			return -1;
		}
	}
}
