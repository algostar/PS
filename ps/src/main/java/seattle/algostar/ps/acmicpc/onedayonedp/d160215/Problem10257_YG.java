/*
 * @(#)Problem10257_YG.java $version 2016. 2. 21.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160215;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem10257_YG {
	public static void main(String[] args){
		new Problem10257_YG().run();
	}
	
	int[] visit = new int[20];
	int rst;
	public void run(){
		dfs(0);
		System.out.println(rst);
	}
	
	public void dfs(int v){
		if(v>=8){
			rst++;
			for(int i=0;i<8;i++){
				System.out.print(visit[i] + " ");
			}
			System.out.println();
			return;
		}
		//dfs(n+1);
		//dfs(n+2);
		//dfs(n+3);

		dfs(v+1);
		visit[v]=1;
		dfs(v+3);
		visit[v]=0;
//		visit[v]=1;
//		dfs(v+3);
//		visit[v]=0;
		
	}
}
