/*
 * @(#)Problem2624_YG2.java $version 2016. 3. 21.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2624_YG2 {
	public static void main(String[] args){
		new Problem2624_YG2().run();
	}
	
	int[][][] cache;
	int s;
	int n;
	int[] coin;
	int[] coinc;
	int[] prev;
	int[] now;
	int[] temp;
	public void run(){
		Scanner sc = new Scanner(System.in);
		s=sc.nextInt();
		n=sc.nextInt();
		cache=new int[2][s+1][1001];
		coin = new int[n+1];
		coinc = new int[n+1];
		prev = new int[s+1];
		now = new int[s+1];
		for(int i=1;i<=n;i++){
			coin[i]=sc.nextInt(); coinc[i]=sc.nextInt();
		}
	
		cache[0][0][0]=1;
		now[0]=1;
		
		for(int i=1;i<=n;i++){
			for(int j=0;j<=s;j++){
				for(int k=0;k<=coinc[i];k++){
					if(k==0){
						cache[i%2][j][k]=now[j];
					}else if(j-coin[i]>=0 && k>=1){
						cache[i%2][j][k]+=cache[i%2][j-coin[i]][k-1];
					}
					prev[j]+=cache[i%2][j][k];
				}
			}
			temp=now;
			now=prev;
			Arrays.fill(temp, 0);
			prev=temp;
		}
		int rst=0;
		for(int i=0;i<=coinc[n];i++){
			rst+=cache[n%2][s][i];
		}
		System.out.println(rst);
	}
}
