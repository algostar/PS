/*
 * @(#)Problem10820_YG.java $version 2015. 12. 17.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10820_YG {
	public static void main(String[] args) throws IOException{
		new Problem10820_YG().run();
	}
	
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String in = br.readLine();
			if(in != null){
				char[] cin = in.toCharArray();
				int l =0; int h=0; int d =0; int s =0;
				for(int i=0;i<cin.length;i++){
					if(cin[i] >= 'a' && cin[i] <= 'z') l++;
					if(cin[i] >= 'A' && cin[i] <= 'Z') h++;
					if(cin[i] >= '0' && cin[i] <= '9') d++;
					if(cin[i] == ' ') s++;
				}
				System.out.println(l + " " + h + " " + d + " " + s);
			}else{
				break;
			}
		}
	}
}
