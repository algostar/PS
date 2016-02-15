/*
 * @(#)Problem11724_YG.java $version 2016. 2. 14.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem11724_YG {
	public static void main(String[] args){
		new Problem11724_YG().run();
	}
	
	int vs;
	int es;
	List<List<Integer>> g = new ArrayList<List<Integer>>();
	boolean[] visit;
	public void run(){
		Scanner sc = new Scanner(System.in);
		vs = sc.nextInt();
		es = sc.nextInt();
		
		visit = new boolean[vs+1];
		visit[0]=true;
		for(int i=0;i<=vs;i++){
			g.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<es;i++){
			int f = sc.nextInt();
			int t = sc.nextInt();
			g.get(f).add(t);
			g.get(t).add(f);
		}
		
		int cnt =0;
		for(int i=1;i<=vs;i++){
			if(!visit[i]){
				dfs(i); cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public void dfs(int v){
		visit[v] = true;
		
		for(Integer elem : g.get(v)){
			if(!visit[elem]){
				dfs(elem);
			}
		}
	}
}
