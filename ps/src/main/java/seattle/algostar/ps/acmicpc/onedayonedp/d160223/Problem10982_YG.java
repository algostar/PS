/*
 * @(#)Problem10982_YG.java $version 2016. 2. 24.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10982_YG {
	public static void main(String[] args){
		new Problem10982_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();

		while(cases-- >0){
			int n = sc.nextInt();
			int[] ov1 = new int[n];
			int[] ov2 = new int[n];
			
			for(int i=0;i<n;i++){
				ov1[i]=sc.nextInt();
				ov2[i]=sc.nextInt();
			}
			
			int[] cache = new int[n+1];
			int[][] bcache = new int[2][100*n+1];
			Arrays.fill(bcache[0], 987654321);
			Arrays.fill(bcache[1], 987654321);
			Arrays.fill(cache, 987654321);
			
			bcache[0][0]=ov2[0];
			bcache[0][ov1[0]]=0;
			cache[0] = Math.min(ov1[0], ov2[0]);
			for(int i=1;i<n;i++){
				int mod=i%2;
				for(int j=0;j<=100*n;j++){
					bcache[mod][j] = j-ov1[i]>=0 ? bcache[1-mod][j-ov1[i]]:987654321;
					bcache[mod][j] = Math.min(bcache[mod][j], bcache[1-mod][j]+ov2[i]);
					cache[i] = Math.min(cache[i], Math.max(j, bcache[mod][j]));
				}
			}
			System.out.println(cache[n-1]);
		}
	}
}
