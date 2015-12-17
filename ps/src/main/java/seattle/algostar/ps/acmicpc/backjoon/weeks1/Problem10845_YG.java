/*
 * @(#)Problem10845.java $version 2015. 12. 16.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem10845_YG {
	public static void main(String[] args){
		new Problem10845_YG().run();
	}
	
	Queue<Integer> q = new LinkedList<Integer>();
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			String op = sc.next();
			if(op.equals("push")){
				q.add(sc.nextInt());
			}else{
				process(op);
			}
		}
	}
	
	public void process(String s){
		if(s.charAt(0) == 'p'){
			System.out.println(q.isEmpty() ? -1: q.poll());
		}else if(s.charAt(0) == 's'){
			System.out.println(q.size());
		}else if(s.charAt(0) == 'e'){
			System.out.println(q.isEmpty()?1:0);
		}else if(s.charAt(0) == 'f'){
			System.out.println(q.isEmpty()?-1:q.peek());
		}else if(s.charAt(0) == 'b'){
			if(q.isEmpty()){
				System.out.println(-1);
			}else{
				int last = 0;
				for(int elem : q){
					last = elem;
				}
				System.out.println(last);
			}
		}
	}
}
