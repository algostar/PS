/*
 * @(#)Problem1644_YG.java $version 2016. 3. 10.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks3;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1644_YG {
	public static void main(String[] args){
		new Problem1644_YG().run();
	}
	
	boolean[] isPrime = new boolean[4000001];
	int[] a = new int[4000001];
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		Arrays.fill(isPrime, true);
		int k=1;
		for(int i=2;i<=4000000;i++){
			if(!isPrime[i]) continue;
			isPrime[i]=true;
			a[k++]=i;
			for(int j=i*2;j<=4000000;j+=i){
				isPrime[j]=false;
			}
		}
	
		int tail=0; int s=0; int rst=0;
		for(int i=1;i<=n;i++){
			s+=a[i];
			while(s>n && tail<i){
				tail++;
				s-=a[tail];
			}
			if(s==n) rst++;
		}
		
		System.out.println(rst);
	}
}
