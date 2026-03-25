package binarySearch;

class SplitLargestsum {

	public int splitArray(int[] nums, int k) {
		long start = 0;
		long end = 0;

		for (int i = 0; i < nums.length; i++) {
			start = Math.max(start, nums[i]);
			end += nums[i];
		}

		while (start < end) {
			// try for mid as potential answer
			long mid = start + (end - start) / 2;

			// calculate how many pieces you can divide this in with this max sum
			long sum = 0;
			int pieces = 1;
			for (int num : nums) {
				if (sum + num > mid) {
					// you cannot add this in this subarray,make new one
					// say you add this num in new subarray, then sum = num
					sum = num;
					pieces++;
				} else {
					sum += num;
				}
			}

			if (pieces > k) {
				start = mid + 1;
			} else {
				end = mid;
			}

		}
		return (int) start; // here start == end
	}

}

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 7, 2, 5, 10, 8 };
		int k = 2;
		SplitLargestsum solver = new SplitLargestsum();
		int result = solver.splitArray(nums, k);
		System.out.println("---START---");
		System.out.println(result);
		System.out.print("---END---");
	}

}
