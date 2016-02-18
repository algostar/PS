/*
 * @(#)Problem10800_YG.java $version 2016. 2. 19.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10800_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem10800_YG().run();
	}
	
	int[] color;
	int[] rst;
	ball[] b;
	int n;
	int total;
	int prev;
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.valueOf(br.readLine());
		color = new int[n]; rst = new int[n]; b = new ball[n]; 
		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			b[i] = new ball(Integer.valueOf(st.nextToken())-1, Integer.valueOf(st.nextToken()), i);
		}
		
		Arrays.sort(b);	
		for(int i=1;i<n;i++){
			if(b[i].size != b[i-1].size){
				total += b[i-1].size;
				color[b[i-1].color] += b[i-1].size;
				rst[b[i].idx] = total - color[b[i].color];
			}else{
				total += b[i-1].size;
				color[b[i-1].color] += b[i-1].size;
				rst[b[i].idx] = prev;
			}
			prev = rst[b[i].idx];
		}
		
		for(int i=0;i<n;i++){
			bw.write(String.valueOf(rst[i]));
			bw.newLine();
		}
		bw.flush();
	}
	
	class ball implements Comparable<ball>{
		int size;
		int color;
		int idx;
		
		public ball(int color, int size, int idx){
			this.size = size; this.color = color; this.idx = idx;
		}

		@Override
		public int compareTo(ball o) {
			return this.size > o.size ? 1 : -1;
		}
	}
}
