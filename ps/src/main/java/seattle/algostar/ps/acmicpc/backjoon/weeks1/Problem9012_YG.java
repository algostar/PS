/*
 * @(#)Problem9012_YG.java $version 2015. 12. 16.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;
import java.util.Stack;

public class Problem9012_YG {
	public static void main(String[] args){
		new Problem9012_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-- >0){
			char[] in = sc.next().toCharArray();
			Stack<Character> stk = new Stack<Character>();
			boolean isMatch = true;
			for(char elem : in){
				if(elem == '('){
					stk.add(elem);
				}else{
					if(stk.isEmpty()){
						isMatch =false;
						break;
					}
					stk.pop();
				}
			}
			
			if(stk.isEmpty() && isMatch){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
