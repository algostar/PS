/*
 * @(#)Problem6588_YG.java $version 2015. 12. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem6588_YG {
	public static void main(String[] args){
		new Problem6588_YG().run();
	}
	
	boolean[] p = new boolean[1000001];
	public void run(){
		List<Integer> rst = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		for(int i=2;i<1000001;i++){
			if(!p[i]){
				rst.add(i);
				for(int j=i*2;j<1000001;j+=i){
					p[j] = true;
				}
			}
		}
		
		while(true){
			int in = sc.nextInt();
			if(in == 0) break;
			
			boolean isFind = false;
			for(int elem:rst){
				int b = in - elem;
				int s=0; int e=rst.size();
				boolean isPrime = false;
				while(s<=e){
					int mid = (s+e)/2;
					if(rst.get(mid) == b){
						isPrime = true; break;
					}else if(rst.get(mid) > b){
						e=mid-1;
					}else{
						s=mid+1;
					}
				}
				if(isPrime){
					System.out.println(in + " = " + elem + " + " + b);
					isFind = true;
					break;
				}
			}
			
			if(!isFind){
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
}
