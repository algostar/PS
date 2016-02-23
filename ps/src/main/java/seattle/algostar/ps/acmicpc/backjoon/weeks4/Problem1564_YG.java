/*
 * @(#)Problem1564_YG.java $version 2016. 2. 22.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks4;

import java.util.Scanner;

public class Problem1564_YG {
	public static void main(String[] args){
		new Problem1564_YG().run();
	}
	
	int k;
	int n;
	int[] s;
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt(); n = sc.nextInt();
		s=new int[k];
		int max=0;
		for(int i=0;i<k;i++){
			s[i] =sc.nextInt();
			max = Math.max(max, s[i]);
		}
		int s=1;
		int e=max;
		
		int mid=0;
		while(s<e){
			mid = (s+e+1)/2;
			int rst = score(mid);
			if(n<=rst){
				s=mid;
			}else if(rst<n){
				e=mid-1;
			}
		}
		System.out.println(s);
	}
	
	public int score(long a){
		int rst =0;
		for(int i=0;i<k;i++){
			rst+= s[i] / a;
		}
		return rst;
	}
}	
