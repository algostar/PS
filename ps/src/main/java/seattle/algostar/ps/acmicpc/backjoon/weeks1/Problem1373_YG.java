/*
 * @(#)Problem1373_YG.java $version 2015. 12. 8.
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

public class Problem1373_YG {
	public static void main(String[] args) throws IOException{
		new Problem1373_YG().run();
	}
	
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in = br.readLine();
		int id = in.length() % 3;
		if(id ==1){
			bw.write(String.valueOf(in.charAt(0) - '0'));
		}else if(id==2){
			bw.write(String.valueOf((in.charAt(0) - '0')* 2 + (in.charAt(1) - '0')));
		}
		
		for(int i =id; i< in.length();i+=3){
			bw.write(String.valueOf((in.charAt(i) - '0') * 4 + (in.charAt(i+1) - '0') * 2 + (in.charAt(i+2) -'0')));
		}
		
		bw.close();
	}
}
