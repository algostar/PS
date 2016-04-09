/*
 * @(#)Problem11881_YG.java $version 2016. 4. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11881_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem11881_YG().run();
	}
	
	int n;
	int[] a;
	int[][] cache;
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		cache=new int[n+1][4];
		a=new int[n+1];
		for(int i=1;i<=n;i++){
			a[i]=Integer.valueOf(st.nextToken());
		}
		Arrays.sort(a);
		cache[1][1]=a[1];
		for(int i=2;i<=n;i++){
			cache[i][3]=cache[i-1][3];
			cache[i][2]=cache[i-1][2];
			cache[i][1]=a[i];
			
			for(int r=n-1;r>=1;r--){
				if(a[i]>a[r]){
					cache[i][3]+=cache[i-1][2]*a[i];
					cache[i][3]%=1000000007;
					cache[i][2]+=cache[i-1][1]*a[i];
					cache[i][2]%=1000000007;
				}else{
					break;
				}
			}
		}
		int rst=0;
		for(int i=1;i<=n;i++){
			rst+=cache[i][3];
			rst%=1000000007;
		}
		System.out.println(Arrays.deepToString(cache));
		System.out.println(rst);
	}
}
