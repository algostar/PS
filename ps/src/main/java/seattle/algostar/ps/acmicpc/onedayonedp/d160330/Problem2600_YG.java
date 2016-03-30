/*
 * @(#)Problem2600_YG.java $version 2016. 3. 31.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Scanner;

public class Problem2600_YG {
	public static void main(String[] args) {
		new Problem2600_YG().run();
	}

	int[] c = new int[3];
	int[][] cache;
	int k1;
	int k2;

	public void run() {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			c[i] = sc.nextInt();
		}
		for (int r = 0; r < 5; r++) {
			k1 = sc.nextInt();
			k2 = sc.nextInt();
			cache = new int[k1+1][k2+1];
			int rst=0;
			for (int i=0;i<=k1;i++) {
				for (int j=0;j<=k2;j++) {
					if(i== 0 && j==0){
						cache[0][0]=2;
						continue;
					}
					rst=2;
					for (int k = 0; k < 3; k++) {
						if (i>=c[k] && cache[i-c[k]][j] == 2) {
							rst = 1;
							break;
						}
						if (j>=c[k] && cache[i][j-c[k]] == 2) {
							rst = 1;
							break;
						}
					}
					cache[i][j]=rst;
				}
			}

			System.out.println(cache[k1][k2] == 1 ? "A" : "B");
		}
	}
}
