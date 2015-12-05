/*
 * @(#)Problem10173.java $version 2015. 12. 5.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Problem10173 {
	public static void main(String[] args) throws IOException{
		new Problem10173().run();
	}
	
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String input = br.readLine();
			if(input.equals("EOI")) break;
			
			if(input.toLowerCase().contains("nemo")){
				System.out.println("Found");
			}else{
				System.out.println("Missing");
			}
		}
	}
}
