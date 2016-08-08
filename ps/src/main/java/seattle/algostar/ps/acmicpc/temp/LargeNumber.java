/*
 * @(#)LargeNumber.java $version 2016. 2. 22.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.temp;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 쇼핑관리개발팀 정용균
 * 2^1000 의 각 자릿수별 합
 */
public class LargeNumber {
	public static void main(String[] args){
		new LargeNumber().run();
	}
	
	int[] a = {5, 3, 1, 4, 2, 7};
	Integer[] b = {0, 1, 2, 3, 4, 5};
	
	class MyCompare implements Comparator<Integer>{
		/**
		 * @param o1
		 * @param o2
		 * @return
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Integer o1, Integer o2) {
			return a[o1]-a[o2];
		}
		
	}
	public void run(){
		System.out.println("aaaaa".substring(0, 2));
		Map<String, Integer> m = new LinkedHashMap(){{
			put("aa", 1);
			put("bb", 1);
			put("cc", 1);
			put("dd", 1);
			put("ee", 1);
			put("ff", 1);
		}};
		
		System.out.println(m.toString());
//		Arrays.sort(b, new MyCompare());
//		System.out.println(Arrays.toString(b));
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
