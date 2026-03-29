package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 2 };
		List<List<Integer>> ans = subsetDuplicate(arr);
		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}

	static List<List<Integer>> subset(int[] arr) {
		List<List<Integer>> outer = new ArrayList<>();

		outer.add(new ArrayList<>());

		for (int num : arr) {
			int n = outer.size();
			for (int i = 0; i < n; i++) {
				List<Integer> internal = new ArrayList<Integer>(outer.get(i));
				internal.add(num);
				outer.add(internal);
			}
		}

		return outer;
	}

	static List<List<Integer>> subsetDuplicate(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> outer = new ArrayList<>();

		outer.add(new ArrayList<>());
		int start = 0;
		int end = 0;

		for (int i = 0; i < arr.length; i++) {
			start = 0;
			// If the current element is the same as previous one , s = e + 1;
			if (i > 0 && arr[i] == arr[i - 1]) {
				start = end + 1;
			}
			end = outer.size() - 1;
			int n = outer.size();
			for (int j = start; j < n; j++) {
				List<Integer> internal = new ArrayList<Integer>(outer.get(j));
				internal.add(arr[i]);
				outer.add(internal);
			}
		}

		return outer;
	}
}
