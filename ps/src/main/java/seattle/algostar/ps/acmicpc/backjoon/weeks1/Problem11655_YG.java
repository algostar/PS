/*
 * @(#)Problem11655_YG.java $version 2015. 12. 17.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem11655_YG {
	public static void main(String[] args){
		new Problem11655_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		char[] in = sc.nextLine().toCharArray();
		for(int i=0;i<in.length;i++){
			if(in[i] >= 'a' && in[i] <='z'){
				in[i] = (char)('a' + (in[i] - 'a'+ 13) % 26);
			}else if(in[i] >= 'A' && in[i] <= 'Z'){
				in[i] = (char)('A' + (in[i] - 'A' +13) % 26);
			}
		}
		for(int i=0;i<in.length;i++){
			System.out.print(in[i]);
		}
	}
}
