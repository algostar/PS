/*
 * @(#)Problem11651_YG.java $version 2015. 12. 18.
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

public class Problem11651_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem11651_YG().run();
	}
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		List<Num> l = new ArrayList<Num>();
		for(int i=0;i<n;i++){
			String[] in = br.readLine().split(" ");
			l.add(new Num(Integer.valueOf(in[0]), Integer.valueOf(in[1])));
		}
		Collections.sort(l);
		for(int i=0;i<n;i++){
			bw.write(l.get(i).x + " " + l.get(i).y);
			bw.newLine();
		}
		bw.close();
	}
	
	class Num implements Comparable<Num>{
		int x; int y;
		public Num(int x, int y){
			this.x = x; this.y = y;
		}
		/**
		 * @param o
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Num o) {
			return this.y>o.y?1:this.y==o.y?this.x>o.x?1:-1:-1;
		}
	}
}
