/*
 * @(#)Problem1949_YG.java $version 2016. 4. 1.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1949_YG {
	public static void main(String[] args){
		new Problem1949_YG().run();
	}
	
	List<List<Integer>> g = new ArrayList<List<Integer>>();
	int[] people;
	int[][] cache;
	int n;
	int[] visited;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		people=new int[n+1];
		cache=new int[n+1][2];
		visited = new int[n+1];
		
		for(int i=1;i<=n;i++){
			people[i]=sc.nextInt();
			g.add(new ArrayList<Integer>());
		}
		g.add(new ArrayList<Integer>());
		for(int i=1;i<n;i++){
			int f=sc.nextInt();
			int t=sc.nextInt();
			g.get(f).add(t);
			g.get(t).add(f);
		}
		
		System.out.println(Math.max(f(1,0), f(1,1)));
	}
	
	int f(int idx, int type){
		
		if(cache[idx][type]!=0) return cache[idx][type];
		int rst= type==1?people[idx]:0;
		visited[idx]=1;
		for(int elem : g.get(idx)){
			if(visited[elem]==0){
				if(type==1){
					rst=Math.max(rst, rst+f(elem,0));
				}else{
					rst=Math.max(rst, Math.max(rst+f(elem,0), rst+f(elem,1)));
				}
			}
		}
		visited[idx]=0;
		return cache[idx][type]=rst;
	}
}
