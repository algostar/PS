/*
 * @(#)Problem10951_YG.java $version 2015. 12. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10951_YG {
	public static void main(String[] args) throws IOException{
		new Problem10951_YG().run();
	}
	
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String input = br.readLine();
			if(input == null) break;
			
			int sum = 0;
			StringTokenizer tokenizer = new StringTokenizer(input);
			
			while(tokenizer.hasMoreTokens()){
				sum += Integer.valueOf(tokenizer.nextToken());
			}
			
			System.out.println(sum);
		}
	}
}
