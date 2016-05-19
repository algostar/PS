/*
 * @(#)Problem2635_YG.java $version 2016. 5. 19.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.koi2000;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2635_YG {
	public static void main(String[] args){
		new Problem2635_YG().run();
	}
	
	int k;
	int[] rst;
	int rstCount;
	public void run(){
		Scanner sc = new Scanner(System.in);
		k=sc.nextInt();
		
		rst=new int[30000];

		int maxCount=0;
		int[] maxResult=null;
		for(int i=1;i<=k;i++){
			rst[0]=k;
			rst[1]=i;
			rstCount=2;
		
			while(rst[rstCount-2]-rst[rstCount-1]>=0){
				rst[rstCount]=rst[rstCount-2]-rst[rstCount-1];
				rstCount++;
			}
			
			if(maxCount<rstCount){
				maxCount=rstCount;
				maxResult=Arrays.copyOf(rst, rstCount);
			}
		}
		
		System.out.println(maxCount);
		for(int i=0;i<maxCount;i++){
			System.out.print(maxResult[i]+" ");
		}
	}
}
