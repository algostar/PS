/*
 * @(#)Problem2309_YG.java $version 2016. 8. 1.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.sido.si2004;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2309_YG {
	public static void main(String[] args){
		new Problem2309_YG().run();
	}
	
	int[] s = new int[9];
	int sum;
	public void run(){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++){
			s[i]=sc.nextInt();
			sum+=s[i];
		}
		
		Arrays.sort(s);
		for(int i=0;i<8;i++){
			for(int j=i+1;j<9;j++){
				if(sum-s[i]-s[j]==100){
					for(int k=0;k<9;k++){
						if(k!=i && k!=j){
							System.out.println(s[k]);
						}
					}
				}
			}
		}
	}
}
