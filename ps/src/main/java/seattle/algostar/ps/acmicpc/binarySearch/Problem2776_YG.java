/*
 * @(#)Problem2776_YG.java $version 2016. 1. 21.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Problem2776_YG {
	public static void main(String[] args) throws IOException{
		new Problem2776_YG().run();
	}
	
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.valueOf(br.readLine());
		while(cases-->0){
			Set<Integer> s = new HashSet<Integer>();
			int r = Integer.valueOf(br.readLine());
			String[] ra = br.readLine().split(" ");
			int l =  Integer.valueOf(br.readLine());
			String[] la = br.readLine().split(" ");
			
			for(int i=0;i<r;i++){
				s.add(Integer.valueOf(ra[i]));
			}
			
			for(int i=0;i<l;i++){
				if(s.contains(Integer.valueOf(la[i]))){
					bw.write("1");
					bw.newLine();
				}else{
					bw.write("0");
					bw.newLine();
				}
			}
		}
		bw.flush();
	}
}
