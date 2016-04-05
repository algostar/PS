package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2352_JW {
	//	public static void main(String[] args) {
	//		new Problem2352_JW().solve();
	//	}

    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = (l + r)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
 
    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else {
            	// A[i] wants to be current end candidate of an existing
            	// subsequence. It will replace ceil value in tailTable
            	int idx = CeilIndex(tailTable, -1, len-1, A[i]);
            	System.out.println("CeilIndex : " + idx);
            	tailTable[idx] = A[i];
            }
            System.out.println("i = " + i + ", len = " + len);
        }
        
        System.out.println(Arrays.toString(tailTable));
 
        return len;
    }
 
    // Driver program to test above function
    public static void main(String[] args)
    {
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is "+
                            LongestIncreasingSubsequenceLength(A, n));
    }
    
	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		int[] in = new int[nn+1];
		for (int i = 1; i <= nn; i++) in[i] = sc.nextInt();
		
		int[] DT = new int[nn+1];
		Arrays.fill(DT, 1);
		int max = 0;
		for (int i = 1; i <= nn; i++) {
			for (int j = i-1; j >= 1; j--) {
				if (in[i] > in[j]) {
					DT[i] = Math.max(DT[i], DT[j] + 1);
					max = Math.max(max, DT[i]);
				}
			}
		}
		System.out.println(max);
	}
}
