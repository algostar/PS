/*
 * @(#)Problem2588_YG.java $version 2016. 8. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.sido.si2005;

import java.util.Scanner;

public class Problem2588_YG {
	public static void main(String[] args){
		new Problem2588_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int s1=sc.nextInt();
		int s2=sc.nextInt();
		int rst=0;
		int d=1;
		for(int i=0;i<3;i++){
			int ps=(s2/d)%10*s1;
			System.out.println(ps);
			rst+=ps*d;
			d*=10;
		}
		System.out.println(rst);
	}
}
