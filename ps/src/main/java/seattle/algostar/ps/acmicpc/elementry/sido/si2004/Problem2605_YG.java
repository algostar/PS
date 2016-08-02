/*
 * @(#)Problem2605_YG.java $version 2016. 8. 1.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.sido.si2004;

import java.util.Scanner;

public class Problem2605_YG {
	public static void main(String[] args){
		new Problem2605_YG().run();
	}
	
	int[] s;
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		s=new int[n];
		for(int i=1;i<=n;i++){
			move(sc.nextInt(), i);
		}
		for(int i=0;i<n;i++){
			System.out.print(s[i] + " ");
		}
	}
	
	public void move(int dist, int index){
		int storeIndex=index-1;
		for(int i=1;i<=dist;i++){
			s[storeIndex]=s[storeIndex-1];
			storeIndex--;
		}
		s[storeIndex]=index;
	}
}
