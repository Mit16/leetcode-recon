package string;

import java.util.ArrayList;

public class SubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		subseq("", "abc");
		System.out.println(subseqReturn("", "abc"));
	}

	static void subseq(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		char ch = up.charAt(0);
		subseq(p + ch, up.substring(1));
		subseq(p, up.substring(1));
	}

	static ArrayList<String> subseqReturn(String p, String up) {
		if (up.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(p);
			return list;
		}

		char ch = up.charAt(0);
		ArrayList<String> left = subseqReturn(p + ch, up.substring(1));
		ArrayList<String> right = subseqReturn(p, up.substring(1));

		left.addAll(right);

		return left;
	}

}
