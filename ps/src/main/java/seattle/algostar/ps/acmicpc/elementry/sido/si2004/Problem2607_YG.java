/*
 * @(#)Problem2607_YG.java $version 2016. 8. 2.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.sido.si2004;

import java.util.Scanner;

public class Problem2607_YG {
	public static void main(String[] args){
		new Problem2607_YG().run();
	}
	
	int n;
	int[][] wordc;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		wordc = new int[n][26];
		for(int i=0;i<n;i++){
			char[] in=sc.next().toCharArray();
			for(int j=0;j<in.length;j++){
				wordc[i][in[j]-'A']++;
			}
		}
		
		int rst=0;
		for(int i=1;i<n;i++){
			if(isSimilar(wordc[0], wordc[i])) rst++;
		}
		System.out.println(rst);
	}
	
	boolean isSimilar(int[] s, int[] c){
		int diff;
		int pc=0;
		int mc=0;
		for(int i=0;i<26;i++){
			diff=s[i]-c[i];
			if(diff==1){
				pc++;
			}else if(diff==-1){
				mc++;
			}else if(diff!=0){
				return false;
			}
		}
		
		return (pc==1 && mc==0)|| (pc==0 && mc==1) || (pc==1 && mc==1) || (pc==0 && mc==0)? true : false;
	}
}
