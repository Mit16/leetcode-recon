package binarySearch;

public class SearchInRotatedsortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 5, 1 };
		int target = 3;

		// Approch 1
//		int pivot = searchPivot(arr);
//		System.out.println(pivot);
//		int result = -1;
//		if (pivot == -1) {
//			result = binarysearch(arr, target, 0, arr.length - 1);
//		} else if (arr[pivot] == target) {
//			result = pivot;
//		} else if (target >= arr[0]) {
//			result = binarysearch(arr, target, 0, pivot - 1);
//		} else {
//			result = binarysearch(arr, target, pivot + 1, arr.length - 1);
//		}
//		System.out.println(result);

		
		// Approch 2
		System.out.print(modifiedBinarySearch(arr, target, 0, arr.length - 1));

	}

	private static int binarysearch(int[] arr, int target, int start, int end) {
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

	private static int searchPivot(int[] arr) {
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
			} else  {
				start = mid;
			}
		}

		return -1;
	}

	private static int searchPivotWithDuplicate(int[] arr) {
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

			if(arr[mid]==arr[start] && arr[mid]==arr[end]) {
				// What if the start or end element were the pivot.
				// check if the start is the pivot
				if(arr[start]> arr[start+1]) {
					return start;
				}
				start++;
				
				//check if end is the pivot
				if(arr[end] < arr[end-1]) {
					return end-1;
				}
				end--;
			}
			// left side is sorted, so pivot should be in right
			else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}

		return -1;
	}
	
	private static int modifiedBinarySearch(int[] arr, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = left + ((right - left) / 2);
		if (arr[mid] == target) {
			return mid;
		}
		if (arr[mid] >= arr[left]) {
			if (arr[left] <= target && target <= arr[mid]) {
				return modifiedBinarySearch(arr, target, left, mid - 1);
			} else {
				return modifiedBinarySearch(arr, target, mid + 1, right);
			}
		} else {
			if (arr[mid] <= target && target <= arr[right]) {
				return modifiedBinarySearch(arr, target, mid + 1, right);
			} else {
				return modifiedBinarySearch(arr, target, left, mid - 1);
			}
		}

	}

}
