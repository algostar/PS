/*
 * @(#)Problem10430.java $version 2015. 12. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem10430_YG {
	public static void main(String[] args){
        new Problem10430_YG().run();
    }
     
    public void run(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
        System.out.println((a+b)%c);
        System.out.println((a%c + b%c)%c);
        System.out.println((a*b)%c);    
        System.out.println((a%c * b%c)%c);
    }
}
