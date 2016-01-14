package seattle.algostar.ps.acmicpc.algorithm;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		new QuickSort().run();
	}

	private void run() {
		int[] A = {3, 5, 1, 2, 5, 7, 5};
		
		quickSort(A, 0, A.length-1);
		
		System.out.println(Arrays.toString(A));
		System.out.println(Integer.toHexString(11));
		//System.out.println();
	}

	private void quickSort(int[] A, int left, int right) {
		if (right > left) {
			int pivot = partition(A, left, right);
			quickSort(A, left, pivot - 1);
			quickSort(A, pivot + 1, right);
		}
	}

	private int partition(int[] A, int left, int right) {
		int pivot = right;
		int store = left;
		for (int ix = left; ix < right; ix++) {
			if (A[ix] <= A[pivot]) {
				swap(A, ix, store++);
			}
		}
		swap(A, store, pivot);
		return store;
	}

	private void swap(int[] A, int pivot, int right) {
		int temp = A[pivot];
		A[pivot] = A[right];
		A[right] = temp;
	}
}
