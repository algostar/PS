/*
 * @(#)Problem11881_3_YG.java $version 2016. 4. 15.
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

public class Problem11881_3_YG {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Problem11881_3_YG().run();
	}

	int n;
	int[] a;
	int[] cnt;
	long x,y,z;

	public void run() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[n+1];
		cnt=new int[100001];
		
		for (int i=1; i<=n; i++) {
			int temp=Integer.valueOf(st.nextToken());
			cnt[temp]+=temp;
			temp%=1000000007;
		}
		for(int i=1;i<=100000;i++){
			x+=cnt[i];
			x%=1000000007;
			y+=(cnt[i]*cnt[i]);
			y%=1000000007;
			z+=(cnt[i]*cnt[i]*cnt[i]);
			z%=1000000007;
		}
		long rst=(x*x%1000000007*x%1000000007)-3*x*y+2*z;
		rst-=3*x%1000000007*y%1000000007;
		rst+=1000000007;
		rst%=1000000007;
		rst/=6;
		rst%=1000000007;
		System.out.println(rst);
	}
}
