/*
 * @(#)Problem2602_YG.java $version 2016. 3. 2.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160302;

import java.util.Scanner;

public class Problem2602_YG {
	public static void main(String[] args){
		new Problem2602_YG().run();
	}
	
	char[] a;
	char[] b;
	char[] c;
	int[][][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		char[] cc=sc.next().toCharArray();
		char[] aa=sc.next().toCharArray();
		char[] bb=sc.next().toCharArray();
		a= new char[aa.length+1]; b= new char[aa.length+1]; c= new char[cc.length+1];
		for(int i=1;i<=aa.length;i++){
			a[i]=aa[i-1]; b[i]=bb[i-1];
		}
		for(int i=1;i<=cc.length;i++)c[i]=cc[i-1];
		
		cache= new int[a.length+1][c.length+1][2];
		cache[0][0][0]=1; cache[0][0][1]=1;
		
		int rst=0;
		for(int i=1;i<=aa.length;i++){
			for(int j=1;j<=cc.length;j++){
				if(b[i]==c[j]){
					for(int k=0;k<i;k++){
						cache[i][j][0]+=cache[k][j-1][1];
					}
				}
				
				if(a[i]==c[j]){
					for(int k=0;k<i;k++){
						cache[i][j][1]+=cache[k][j-1][0];
					}
				}
				if(j==cc.length) rst+=cache[i][j][0]+cache[i][j][1];
			}
		}
		System.out.println(rst);
	}
}
