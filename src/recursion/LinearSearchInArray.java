package recursion;

import java.util.ArrayList;

public class LinearSearchInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 1, 4, 4, 5 };
		System.out.println(find(arr, 4, 0));
		System.out.println(findIndex(arr, 4, 0));
		System.out.println(findIndexLast(arr, 4, arr.length - 1));
		System.out.println(findAllIndex(arr, 4, 0, new ArrayList<Integer>()));
		System.out.println(findAllIndex2(arr, 4, 0));
	}

	static boolean find(int[] arr, int target, int index) {
		if (index == arr.length) {
			return false;
		}

		return arr[index] == target || find(arr, target, index + 1);
	}

	static int findIndex(int[] arr, int target, int index) {
		if (index == arr.length) {
			return -1;
		}
		if (arr[index] == target) {
			return index;
		} else {
			return findIndex(arr, target, index + 1);
		}
	}

	static int findIndexLast(int[] arr, int target, int index) {
		if (index == -1) {
			return -1;
		}
		if (arr[index] == target) {
			return index;
		} else {
			return findIndexLast(arr, target, index - 1);
		}
	}

	static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> result) {
		if (index == arr.length) {
			return result;
		}
		
		if (arr[index] == target) {
			result.add(index);
		}

		return findAllIndex(arr, target, index + 1, result);

	}
	
	static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (index == arr.length) {
			return result;
		}
		
		// this will contain ans for that function call only 
		if (arr[index] == target) {
			result.add(index);
		}

		ArrayList<Integer> ansFromBelow =  findAllIndex2(arr, target, index + 1);
		
		result.addAll(ansFromBelow);
		
		return result;

	}
	
}
