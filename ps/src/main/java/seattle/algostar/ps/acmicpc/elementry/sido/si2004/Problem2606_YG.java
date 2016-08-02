/*
 * @(#)Problem2606_YG.java $version 2016. 8. 2.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.sido.si2004;

import java.util.Scanner;

public class Problem2606_YG {
	public static void main(String[] args){
		new Problem2606_YG().run();
	}
	
	int n;
	int[][] g;
	boolean[] visit;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		g=new int[n+1][n+1];
		visit=new boolean[n+1];
		int ec =sc.nextInt();
		for(int i=0;i<ec;i++){
			int from =sc.nextInt();
			int to=sc.nextInt();
			g[from][to]=g[to][from]=1;
		}
		System.out.println(dfs(1)-1);
	}
	
	int dfs(int x){
		int rst=1;
		visit[x]=true;
		for(int i=1;i<=n;i++){
			if(g[x][i]==1 && !visit[i]){
				rst+=dfs(i);
			}
		}
		
		return rst;
	}
}
