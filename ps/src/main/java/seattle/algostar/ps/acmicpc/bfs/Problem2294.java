/*
 * @(#)Problem2294.java $version 2015. 11. 24.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2294 {
	public static void main(String[] args){
		new Problem2294().run();
	}
	
	int n, k;
	int[] coins;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); k = sc.nextInt(); coins = new int[n];
		for(int i =0; i < n; i++){
			coins[i] = sc.nextInt();
		}
		
		Queue<Integer> kq = new LinkedList<Integer>();
		Queue<Integer> vq = new LinkedList<Integer>();
		
		kq.add(0); vq.add(0);
		
		int[] visit = new int[10001];
		while(!kq.isEmpty()){
			int nowK = kq.peek(); int nowV = vq.peek();
			if(nowK == k) break;
			kq.poll(); vq.poll();
			
			for(int i =0; i <n;i++){
				int nextK = nowK + coins[i]; int nextV = nowV + 1;
				if(nextK <= k && visit[nextK] == 0){
					kq.add(nextK); vq.add(nextV); visit[nextK] = 1;
				}
			}
		}
		
		System.out.println(kq.isEmpty() ? -1 : vq.peek());	
	}
}
