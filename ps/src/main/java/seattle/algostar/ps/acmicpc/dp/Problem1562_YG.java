package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;



/*
 * @(#)Problem1562_YG.java $version 2015. 11. 19.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem1562_YG {
	public static void main(String[] args){
		new Problem1562_YG().run();
	}
	
	int n;
	int[][][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		cache = new int[n + 1][10][1<<10];
		
		int rst = 0;
		for(int i = 0; i < 10; i++){
			rst = (rst + getStepCount(n, i, 1<<i)) % 1000000000;
		}
		
		System.out.println(rst);
	}
	
	public int getStepCount(int nowIndex, int selectDigit, int setDigit){
		if(nowIndex == 1){
			if(selectDigit != 0){
				if(setDigit == (1<<10) - 1){
					return 1;
				}else{
					return 0;
				}
			}else{
				return 0;
			}
		}
		
		if(cache[nowIndex][selectDigit][setDigit] != 0){
			return cache[nowIndex][selectDigit][setDigit];
		}
		
		int rst = 0;
		if(selectDigit >= 1 && selectDigit <= 8){
			rst = (rst + getStepCount(nowIndex - 1, selectDigit + 1, setDigit | 1 << selectDigit + 1)) % 1000000000;
			rst = (rst + getStepCount(nowIndex - 1, selectDigit - 1, setDigit | 1 << selectDigit - 1)) % 1000000000; 
			
		}else if(selectDigit == 0){
			rst = (rst + getStepCount(nowIndex - 1, selectDigit + 1, setDigit | 1 << selectDigit + 1)) % 1000000000;
		}else {
			rst = (rst + getStepCount(nowIndex - 1, selectDigit - 1, setDigit | 1 << selectDigit - 1)) % 1000000000;
		}
		
		return cache[nowIndex][selectDigit][setDigit] = rst;
	}
}
