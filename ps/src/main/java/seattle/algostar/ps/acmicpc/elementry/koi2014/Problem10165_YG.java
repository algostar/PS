/*
 * @(#)Problem10165_YG.java $version 2016. 4. 28.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.koi2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem10165_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem10165_YG().run();
	}
	
	bus[] buss;
	int size;
	int n;
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size=Integer.valueOf(br.readLine());
		n=Integer.valueOf(br.readLine());
		buss=new bus[n];
		for(int i=0;i<n;i++){
			String[] in = br.readLine().split(" ");
			buss[i]=new bus(i,Integer.valueOf(in[0]), Integer.valueOf(in[1]));
		}
		Arrays.sort(buss);
		int max=-1;
		List<Integer> rst = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			if(buss[i].end>max){
				rst.add(buss[i].num);
				max=buss[i].end;
			}
		}
		Arrays.sort(buss,new numComparator());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(buss[i].num).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	class numComparator implements Comparator<bus>{
		/**
		 * @param o1
		 * @param o2
		 * @return
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(bus o1, bus o2) {
			return o1.num-o2.num;
		}
		
	}
	class bus implements Comparable<bus>{
		int num;
		int start;
		int end;
		
		public bus(int num, int s, int e){
			this.start=s; this.end=e; this.num=num;
		}

		/**
		 * @param o
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(bus o) {
			if(this.start==o.start){
				return o.end-this.end;
			}else{
				return this.start-o.start;
			}
		}
	}
}
