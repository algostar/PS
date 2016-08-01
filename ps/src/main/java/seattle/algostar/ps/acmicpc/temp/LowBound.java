/*
 * @(#)LowBound.java $version 2016. 5. 30.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.temp;

import java.util.TreeSet;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class LowBound {
	public static void main(String[] args){
		new LowBound().run();
	}
	
	int[] asc = {3,5,7,9,10,11};
	int[] desc = {11,10,9,7,5,3};
	public void run(){
//		System.out.println(upperB(7));
//		System.out.println(upperB(6));
//		System.out.println(upperB(12));
//		System.out.println(upperB(1));
//		System.out.println(upperB(3));
		TreeSet st = new TreeSet();
	}
	
	public int lowB(int k){
		int s=0;
		int e=6;
		
		while(s<e){
			int m=(s+e)/2;
			if(k<=asc[m]){
				e=m;
			}else{
				s=m+1;
			}
		}
		return e;
	}
	
	public int upperB(int k){
		int s=0;
		int e=6;
		
		while(s<e){
			int m=(s+e)/2;
			if(k<asc[m]){
				e=m;
			}else{
				s=m+1;
			}
		}
		return e;
	}
}
