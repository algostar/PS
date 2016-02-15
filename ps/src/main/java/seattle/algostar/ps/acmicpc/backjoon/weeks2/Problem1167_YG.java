/*
 * @(#)Problem1167_YG.java $version 2016. 2. 15.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1167_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem1167_YG().run();
	}
	
	int n;
	List<List<edge>> t = new ArrayList<List<edge>>();
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		for(int i=0;i<=n;i++) t.add(new ArrayList<edge>());
		for(int i=1;i<=n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());	

			int f = Integer.valueOf(st.nextToken());
			while(true){
				int to = Integer.valueOf(st.nextToken());
				if(to == -1) break;
				int w = Integer.valueOf(st.nextToken());
				
				t.get(f).add(new edge(to,w));
				t.get(to).add(new edge(f,w));	
			}
		}
		
		// 가장 먼 노드
		edge node = bfs(1,new int[n+1], new boolean[n+1]);
		// 가장 먼 노드 기준으로 가장 먼 노드가 지름
		edge rst = bfs(node.v,new int[n+1], new boolean[n+1]);
		System.out.println(rst.w);		
	}
	
	public edge bfs(int v, int[] dist, boolean[] visit){
		Queue<Integer> vq = new LinkedList<Integer>();
		Queue<Integer> wq = new LinkedList<Integer>();
		vq.add(v); wq.add(0); dist[v]=0; visit[v]=true;
		
		while(!vq.isEmpty()){
			int nv = vq.poll();
			int nw = wq.poll();
			
			for(edge elem: t.get(nv)){
				if(!visit[elem.v]){
					visit[elem.v]=true;
					dist[elem.v]=nw+elem.w;
					vq.add(elem.v); wq.add(nw+elem.w);
				}
			}
		}
		
		int mv = 0;
		int mw = -1;
		for(int i=1;i<=n;i++){
			if(mw<dist[i]){
				mv = i; mw=dist[i];
			}
		}
	
		return new edge(mv,mw);
	}
	
	class edge implements Comparable<edge>{
		int v; int w;
		public edge(int v, int w){
			this.v=v; this.w=w;
		}
		@Override
		public int compareTo(edge o) {
			return this.w < o.w ? 1 : -1;
		}
	}
}