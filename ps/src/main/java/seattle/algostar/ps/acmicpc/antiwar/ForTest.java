/*
 * @(#)ForTest.java $version 2016. 7. 3.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.antiwar;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class ForTest {
	public static void main(String[] args){
		new ForTest().run();
	}
	
	public void run(){

		for(int i=0,j=0;i<5 || j<5;i++,j++){
			System.out.println(String.valueOf(i) + String.valueOf(j));
		}
	}
}
