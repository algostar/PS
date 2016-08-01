/*
 * @(#)LargeNumber.java $version 2016. 2. 22.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 쇼핑관리개발팀 정용균
 * 2^1000 의 각 자릿수별 합
 */
public class LargeNumber {
	public static void main(String[] args){
		new LargeNumber().run();
	}
	
	public void run(){
		List<String> list = new ArrayList<String>();
		
		BlockingQueue<String> pendingList = new LinkedBlockingQueue<String>(10);
		pendingList.add("pending1");
		pendingList.add("pending2");
		pendingList.add("pending3");
		
		int cnt = pendingList.drainTo(list, 10);
		System.out.println(cnt);
		System.out.println(pendingList.size());
		System.out.println(list.size());
//		double d = 1;
//		//System.out.println(d/49);
//		System.out.println(1.0d/49*49);
////		System.out.println(d*49/49);
////		Integer[] a = {1,2,3,4,5,6,7};
////		
////		Arrays.sort(a, new MyComparator());
////		for(int elem:a){
////			System.out.println(elem);
////		}
//		
//		TreeSet<Integer> ts = new TreeSet<Integer>(Arrays.asList(4,7,9,10));
//		System.out.println(ts.lower(9));
//		System.out.println(ts.higher(9));
	}
	
//	class MyComparator implements Comparator<Integer>{
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			return o2-o1;
//		}
//	}
}
