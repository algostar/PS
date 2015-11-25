/*
 * @(#)Problem2490.java $version 2015. 11. 25.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry;

import java.util.Scanner;

public class Problem2490 {
	public static void main(String[] args){
		new Problem2490().run();
	}

	public void run(){
		Scanner sc = new Scanner(System.in);
		String[] determin = new String[5];
		
		determin[0] = "E"; determin[1] = "A"; determin[2] = "B"; determin[3] = "C"; determin[4] = "D";
		
		for(int i =0; i<3;i++){
			int count =0;
			for(int j =0; j<4;j++){
				if(sc.nextInt() == 0) count++;
			}
			System.out.println(determin[count]);
		}
	}
}
