class Solution {
    public int search(int[] arr, int target) {
        int pivot = searchPivot(arr);
		
	int result = -1;
		if (pivot == -1) {
			result = binarysearch(arr, target, 0, arr.length - 1);
		} else if (arr[pivot] == target) {
			result = pivot;
		} else if (target >= arr[0]) {
			result = binarysearch(arr, target, 0, pivot - 1);
		} else {
			result = binarysearch(arr, target, pivot + 1, arr.length - 1);
		}
        return result;
    }

     int binarysearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target < arr[mid]) {
				end = mid - 1;
			} else if (target > arr[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}

		}

		return -1;
	}

	 int searchPivot(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}

			if (arr[mid] <= arr[start]) {
				end = mid - 1;
			} else {
				start = mid;
			}
		}

		return -1;
	}

}