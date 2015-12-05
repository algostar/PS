/*
 * @(#)Problem11637.java $version 2015. 12. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.easy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11637 {
	public static void main(String[] args){
		new Problem11637().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		while(cases-- > 0){
			int n = sc.nextInt();
			vote[] vList = new vote[n];
			int sum = 0;
			for(int i = 0; i < n; i++){
				int vCount = sc.nextInt(); sum += vCount;
				vList[i] = new vote(i+1, vCount);
			}
			
			Arrays.sort(vList);
			System.out.println(vList[0].count == vList[1].count ? "no winner" : vList[0].count * 2 > sum ? "majority winner " + vList[0].num : "minority winner " + vList[0].num);
		}
	}
	
	class vote implements Comparable<vote>{
		int num;
		int count;
		
		public vote(int num, int count){
			this.num = num;
			this.count = count;
		}

		/**
		 * @param o
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(vote o) {
			return this.count < o.count ? 1 : -1;
		}
	}
}
