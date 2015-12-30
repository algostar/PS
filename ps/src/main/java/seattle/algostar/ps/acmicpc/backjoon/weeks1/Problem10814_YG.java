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

public class Problem10814_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem10814_YG().run();
	}
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		List<Mem> ml = new ArrayList<Mem>();
		for(int i=0;i<n;i++){
			String[] in = br.readLine().split(" ");
			ml.add(new Mem(i, Integer.valueOf(in[0]), in[1]));
		}
		Collections.sort(ml);
		for(int i=0;i<n;i++){
			bw.write(ml.get(i).a + " " + ml.get(i).na);
			bw.newLine();
		}
		bw.close();
	}
	
	class Mem implements Comparable<Mem>{
		int o; int a; String na;
		public Mem(int o, int a, String na){
			this.o = o; this.a =a; this.na=na;
		}
		/**
		 * @param o
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Mem o) {
			return this.a>o.a?1:this.a==o.a?(this.o>o.o?1:-1):-1;
		}
	}
}
