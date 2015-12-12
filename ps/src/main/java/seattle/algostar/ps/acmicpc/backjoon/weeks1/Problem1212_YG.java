/*
 * @(#)Problem1212_YG.java $version 2015. 12. 11.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1212_YG {
	public static void main(String[] args) throws IOException{
		new Problem1212_YG().run();
	}
	
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		StringBuilder b = new StringBuilder();
		
		
		for(int i=0;i<in.length();i++){
			int a = in.charAt(i) - '0';
			String s = "";
			
			for(int j=0;j<3;j++){
				int m = a-(a/2)*2;
				a=a/2;
				s = m + s;
				if(i == 0 && a == 0) break;
			}
			b.append(s);
		}
		System.out.println(b.toString());
	}
}
