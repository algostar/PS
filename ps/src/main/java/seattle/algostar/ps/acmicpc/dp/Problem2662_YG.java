/*
 * @(#)Problem2662_YG.java $version 2015. 11. 27.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;
 
public class Problem2662_YG {
    public static void main(String[] args){
        new Problem2662_YG().run();
    }
     
    int k;
    int n;
    int[][] cost;
    int[][] path;
    int[][] cache;
    public void run(){
        Scanner sc = new Scanner(System.in);
         
        k = sc.nextInt();
        n = sc.nextInt();
        cost = new int[n][k + 1];
        path = new int[n + 1][k + 1];
        cache = new int[n][k + 1];
         
        for(int[] m : cache){
            Arrays.fill(m, -1);
        }
         
        for(int i = 1; i <= k; i++){
            sc.nextInt();
            for(int j = 0; j < n; j++){
                cost[j][i] = sc.nextInt();
            }
        }
         
        System.out.println(A(0, k));
        re(0, k);
         
    }
     
    public int A(int idx, int m){
        if(idx > n - 1){
            path[idx][m] = -1;
            return 0;
        }
         
        if(cache[idx][m] != -1){
            return cache[idx][m];
        }
        int rst = Integer.MIN_VALUE;
        int select = 0;
        for(int i =0; i <= m; i++){
            if(A(idx + 1,  m - i) + cost[idx][i] > rst){
                rst = A(idx + 1,  m - i) + cost[idx][i];
                select = i;
            }
        }
         
        path[idx][m] = select;
        return cache[idx][m] = rst;
    }
     
    public void re(int idx, int m){
        if(path[idx][m] == - 1) return;
        System.out.print(path[idx][m]);
        System.out.print(" ");
        int select = path[idx][m];
        re(idx + 1, m - select);
    }
}