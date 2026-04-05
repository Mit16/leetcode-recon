package recursion;

public class numberOfZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumZeroes("0020304050"));
	}
	
	public static int NumZeroes(int n) {
		int count =0;
		return zeroHelper(n,count);
	}
	
	private static int zeroHelper(int n,int count) {
		if(n%10 == n) {
			if(n%10 == 0) count++;
			return count;
		}
		
		if(n%10 == 0) count++;
		return zeroHelper(n/10, count);
	}
	
	public static int NumZeroes(String n) {
		return zeroHelper(n,0);
	}
	
	private static int zeroHelper(String n, int index) {
		if(n.length()==index) {
			return 0;
		}
		
		int count = n.charAt(index) == '0' ? 1:0;
		return count + zeroHelper(n, index+1);
	}
}
