package recursion;

public class DigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(digitSum(2134));

	}

	public static int digitSum(int n) {
		if(n == 0) {
			return 0;
		}
		
		return (n%10)+digitSum(n/10);
	}
	
}
