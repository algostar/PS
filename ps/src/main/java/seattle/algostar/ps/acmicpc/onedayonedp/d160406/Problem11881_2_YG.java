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

public class Problem11881_2_YG {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Problem11881_2_YG().run();
	}

	int n;
	int[] a;
	int[] cnt;
	long[] psum;

	public void run() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = new int[n+1];
		cnt=new int[n+1];
		psum=new long[n+1];
		Arrays.sort(a);
		int idx=0;
		for (int i=1; i<=n; i++) {
			int temp=Integer.valueOf(st.nextToken());
			if(a[idx]!=temp){
				idx++;
				a[idx]=temp;
				cnt[idx]++;
			}else{
				cnt[idx]++;
			}
		}
		for(int i=1;i<=idx;i++){
			psum[i]=psum[i-1]+a[i]*cnt[i];
		}
		long rst=0;
		for(int i=2;i<idx;i++){
			long temp = a[i]*cnt[i];
			temp%=1000000007;
			temp*=psum[i-1];
			temp%=1000000007;
			temp*=(psum[idx]-psum[i]);
			temp%=1000000007;
			rst+=temp;
			rst%=1000000007;
		}
		System.out.println(rst);
	}
}
