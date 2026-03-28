package recursion;

import java.util.Arrays;
import java.util.Iterator;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 4, 3, 2, 1 };
//		arr = mergeSort(arr);
		mergeSortInPlace(arr, 0, arr.length);
		System.out.print(Arrays.toString(arr));
	}

	// This method uses extra space
	static int[] mergeSort(int[] arr) {
		if (arr.length == 1)
			return arr;

		int mid = arr.length / 2;

		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

		return merger(left, right);
	}

	private static int[] merger(int[] first, int[] second) {
		// TODO Auto-generated method stub
		int[] mix = new int[first.length + second.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < first.length && j < second.length) {
			if (first[i] < second[j]) {
				mix[k] = first[i];
				i++;
			} else {
				mix[k] = second[j];
				j++;
			}
			k++;
		}

		// it may be possible that one of the arrays is not complete
		// copy the remaining array
		while (i < first.length) {
			mix[k] = first[i];
			i++;
			k++;
		}

		while (j < second.length) {
			mix[k] = second[j];
			j++;
			k++;
		}

		return mix;
	}

	// Removing the extra usage and doing the in-place sorting
	static void mergeSortInPlace(int[] arr, int s, int e) {
		if (e - s == 1)
			return;

		int mid = s + (e - s) / 2;

		mergeSortInPlace(arr, s, mid);
		mergeSortInPlace(arr, mid, e);

		mergerInPlace(arr, s, mid, e);
	}

	private static void mergerInPlace(int[] arr, int s, int m, int e) {
		// TODO Auto-generated method stub
		int[] mix = new int[e - s];

		int i = s;
		int j = m;
		int k = 0;

		while (i < m && j < e) {
			if (arr[i] < arr[j]) {
				mix[k] = arr[i];
				i++;
			} else {
				mix[k] = arr[j];
				j++;
			}
			k++;
		}

		// it may be possible that one of the arrays is not complete
		// copy the remaining array
		while (i < m) {
			mix[k] = arr[i];
			i++;
			k++;
		}

		while (j < e) {
			mix[k] = arr[j];
			j++;
			k++;
		}

		for (int l = 0; l < mix.length; l++) {
			arr[s + l] = mix[l];
		}

	}

}
