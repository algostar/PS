/*
 * @(#)Problem1654_YG.java $version 2016. 3. 27.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.temp;

import java.util.Scanner;

public class Problem1654_YG {
	public static void main(String[] args){
        new Problem1654_YG().run();
    }
     
	int k;
    int n;
    long[] s;
    public void run(){
        Scanner sc = new Scanner(System.in);
         
        k = sc.nextInt(); n = sc.nextInt();
        s=new long[k];
        long max=0;
        for(int i=0;i<k;i++){
            s[i] =sc.nextInt();
            max = Math.max(max, s[i]);
        }
        long s=max;
        long e=1;
         
        long mid=0;
        while(e<s){
            mid = (s+e+1)/2;
            long rst = score(mid);
            if(n<=rst){
                e=mid;
            }else{
                s=mid-1;
            }
        }
        System.out.println(e);
    }
     
    public long score(long a){
        int rst =0;
        for(int i=0;i<k;i++){
            rst+= s[i] / a;
        }
        return rst;
    }
}
