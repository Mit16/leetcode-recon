package binarySearch;

import java.util.Arrays;

public class findFIrstAndLast {
	public static void main(String[] args) {
		int[] nums = {1};
		int target = 1;
		int[] result = searchRange(nums,target);
		System.out.print(Arrays.toString(result));
		
	}
	
	// Failed approch, can't do it in one loop
//	 public static int[] searchRange(int[] nums, int target) {
//		 int[] result = {-1,-1};
//	        int start = 0;
//	        int end = nums.length - 1;
//	       
//	        while (start <= end) {
//	            int mid = start + (end - start) / 2;
//
//	            if (mid>0 && target == nums[mid]) {
//	                if (target == nums[mid - 1]) {
//	                    result[0] = mid - 1;
//	                    end = mid - 1;
//	                }
//	                if (mid<(nums.length-1)&& target == nums[mid + 1]) {
//	                    result[1] = mid + 1;
//	                    start = mid + 1;
//	                }
//	               break;
//	            } else if (target < nums[mid]) {
//	                end = mid - 1;
//	            } else {
//	                start = mid + 1;
//	            }
//	        }
//
//
//	        return result;
//	    }
	

	 public static int[] searchRange(int[] nums, int target) {
		 int[] result = {-1,-1};
	        
		 result[0] =  search(nums, target, true);
		 result[1] = search(nums, target, false);

	     return result;
	    }
	 
	 private static int search(int[] nums,int target,boolean searchFirst) {
		 int ans = -1;
		 int start = 0;
	     int end = nums.length - 1;
	       
	        while (start <= end) {
	            int mid = start + (end - start) / 2;

	            if (target < nums[mid]) {
	                end = mid - 1;
	            } else if(target > nums[mid]){
	                start = mid + 1;
	            }else {
	            	ans=mid;
	            	if(searchFirst) {
	            		end= mid-1;
	            	}else {
	            		start = mid+1;
	            	}
	            }
	        }
	        
	        return ans;
		 
	 }
}
