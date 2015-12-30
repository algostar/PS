/*
 * @(#)Problem2751_YG.java $version 2015. 12. 18.
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

public class Problem2751_YG {
	 public static void main(String[] args) throws NumberFormatException, IOException{
		 new Problem2751_YG().run();
	 }
	 
	 public void run() throws NumberFormatException, IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 int n = Integer.valueOf(br.readLine());
		 List<Num> nList = new ArrayList<Num>();
		 for(int i=0;i<n;i++){
			 nList.add(new Num(Integer.valueOf(br.readLine())));
		 }
		 
		 Collections.sort(nList);
		 for(int i=0;i<n;i++){
			 bw.write(String.valueOf(nList.get(i).v));
			 bw.newLine();
		 }
		 bw.close();
	 }
	 
	 class Num implements Comparable<Num>{
		 int v;
		 public Num(int v){
			 this.v = v;	 
		 }
		/**
		 * @param o
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Num o) {
			return v > o.v ? 1:-1;
		}
	 }
}
