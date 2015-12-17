/*
 * @(#)Problem10799.java $version 2015. 12. 16.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;
import java.util.Stack;

public class Problem10799_YG {
	public static void main(String[] args){
		new Problem10799_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toCharArray();
		Stack<Integer> stk = new Stack<Integer>();
		int rst = 0;
		for(int i=0;i<in.length;i++){
			if(in[i] == '('){
				stk.add(i);
			}else{
				if(stk.pop()+1 == i){
					rst += stk.size();
				}else{
					rst += 1;
				}
			}
		}
		
		System.out.println(rst);
	}
}
