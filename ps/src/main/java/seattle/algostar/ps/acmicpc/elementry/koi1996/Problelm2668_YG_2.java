/*
 * @(#)Problelm2668_YG_2.java $version 2016. 4. 30.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.koi1996;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problelm2668_YG_2 {
	public static void main(String[] args){
		new Problem2668_YG().run();
	}
	
	int[] in;
	int[] indeg;
	int n;
	int[] rst;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		in = new int[n+1]; 
		indeg=new int[n+1]; 
		rst = new int[n+1];
		Queue q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++){
			in[i]=sc.nextInt();
			indeg[in[i]]++;
		}
		
		for(int i=1;i<=n;i++){
			if(indeg[i]==0) q.add(i);
		}
		
		while(q.isEmpty()){
			
		}
		
		
	}
}
