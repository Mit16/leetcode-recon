package recursion;

public class RecusrionSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,8,5,6,7};
		System.out.print(sorted(arr, 0));
	}
	
	static boolean sorted(int[] arr, int index) {
		if(index == arr.length-1) {
			return true;
		}
		
		return arr[index]<arr[index+1] & sorted(arr, index+1);
	}

}
