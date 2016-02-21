/*
 * @(#)Problem9318.java $version 2014. 10. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
public class Problem9318_YG {
    public static void main(String[] args){
        new Problem9318_YG().run();
    }
     
    Rect[] rects;
    Integer[] ys;
    List<Event> events;
    int[] count;
    int n;
    public void run(){
        Scanner sc = new Scanner(System.in); 
        int cases = sc.nextInt();
         
        while(cases-- > 0){
            n = sc.nextInt();
            rects = new Rect[n];
            events = new ArrayList<Event>();
             
            Set<Integer> ysSet = new HashSet<Integer>();
            for(int i = 0; i < n; i++){
                int x1 = sc.nextInt(); int y1 = sc.nextInt(); int x2 = sc.nextInt(); int y2 = sc.nextInt();
                events.add(new Event(x1, 1, i));
                events.add(new Event(x2, -1, i));
                ysSet.add(y1); ysSet.add(y2);
                rects[i] = new Rect(x1, y1, x2, y2);
                 
            }
             
            ys = ysSet.toArray(new Integer[0]);
            count = new int[ys.length];
             
            Collections.sort(events);
            Arrays.sort(ys);
             
            int rst = 0;
            for(int i =0; i < events.size() - 1; i++){
                int x = events.get(i).x;
                int direction = events.get(i).dir;
                int rectId = events.get(i).rectId;
                int y1 = rects[rectId].y1; int y2 = rects[rectId].y2;
                 
                for(int j =0; j < ys.length -1; j++){
                    if(y1 <= ys[j] && ys[j+1] <= y2){
                        count[j] += direction;
                    }
                }
                 
                int yLength = 0;
                for(int j=0; j< ys.length-1;j++ ){
                    if(count[j] > 0){
                        yLength += ys[j+1] - ys[j];
                    }
                }
                 
                rst += yLength * (events.get(i+1).x - x);
            }
             
            System.out.println(rst);
        }
    }
     
    class Rect {
        int x1; int y1; int x2; int y2;
         
        public Rect(int x1, int y1, int x2, int y2) {
            super();
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
     
    class Event implements Comparable<Event>{
        int x;
        int dir;
        int rectId;
         
        public Event(int x, int dir, int rectId) {
            super();
            this.x = x;
            this.dir = dir;
            this.rectId = rectId;
        }
 
        @Override
        public int compareTo(Event o) {
            if(this.x > o.x){
				return 1;
			}else if( this.x < o.x){
				return -1;
			}else{
				return 0;
			}
        }
    }
}
