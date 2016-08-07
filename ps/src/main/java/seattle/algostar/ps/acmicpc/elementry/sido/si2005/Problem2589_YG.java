/*
 * @(#)Problem2589_YG.java $version 2016. 8. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.sido.si2005;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2589_YG {
	public static void main(String[] args){
		new Problem2589_YG().run();
	}
	
	char[][] s;
	boolean[][] visit;
	int xs;
	int ys;
	int[] dx={1,-1,0,0};
	int[] dy={0,0,1,-1};
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		xs=sc.nextInt();
		ys=sc.nextInt();
		s=new char[xs][ys];
		visit=new boolean[xs][ys];
		
		for(int i=0;i<xs;i++){
			s[i]=sc.next().toCharArray();
		}
		
		int rst=0;
		for(int i=0;i<xs;i++){
			for(int j=0;j<ys;j++){
				if(s[i][j]=='L'){
					for(int k=0;k<xs;k++){
						Arrays.fill(visit[k], false);
					}
					int ps = bfs(i,j);
					rst=Math.max(rst, ps);
				}
			}
		}
		System.out.println(rst);
	}
	
	public int bfs(int x, int y){
		visit[x][y]=true;
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		Queue<Integer> dq = new LinkedList<Integer>();
		int max=0;
		
		xq.add(x); yq.add(y); dq.add(0); visit[x][y]=true;
		
		while(!xq.isEmpty()){
			int nx=xq.poll(); int ny=yq.poll(); int nd=dq.poll();
			max=Math.max(max,nd);
			for(int i=0;i<4;i++){
				int nextX = nx+dx[i]; int nextY=ny+dy[i];
				if(0<=nextX && nextX<xs&& 0<=nextY && nextY<ys && s[nextX][nextY] == 'L' && !visit[nextX][nextY]){
					xq.add(nextX); yq.add(nextY); dq.add(nd+1); visit[nextX][nextY]=true;
				}
			}
		}
		return max;
	}
}
