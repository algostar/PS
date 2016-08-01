package seattle.algostar.ps.acmicpc.temp;

import java.io.*;
import java.util.*;
 
public class Test1 {
    static int[][] distance = new int[1001][1001];
    static int n_island;
     
    public static void main(String[] args) throws IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int total_cycle = Integer.parseInt(br.readLine());
        for (int cycle =0; cycle<total_cycle; cycle++){
            for (int i=0; i<1001; i++){
                Arrays.fill(distance[i], 0);
            }
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            n_island = Integer.parseInt(st.nextToken());
            int n_river = Integer.parseInt(st.nextToken());
            for (int i=0; i<n_river; i++ ){
            	st = new StringTokenizer(br.readLine());
                int is1 = Integer.parseInt(st.nextToken());
                int is2 = Integer.parseInt(st.nextToken());
                distance[is1][is2] = Integer.parseInt(st.nextToken());
                distance[is2][is1] = distance[is1][is2];
            }
             
            distance[1][0] = 20*1000 + 2000000;
            int result = recursive_search(1,0);
            if (result == 20*1000 + 2000000){
                result =0;
            }
            System.out.println(result);
        }
    }//end main
     
    static int recursive_search(int current, int parent){
        int sum=0;
        for(int i=1; i<=n_island;i++){
            if (distance[current][i]>=1 && i!=parent){
                sum = sum + recursive_search( i,current);
            }
        }
        if(sum==0){
            return distance[current][parent];
        }
        return MIN(sum, distance[current][parent]);     
    }
 
    static int MIN(int a, int b) {
        return a > b ? b : a;
    }
  
}