package string;

import java.util.ArrayList;

public class LetterCombinationofPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		pad("", "12");
		System.out.println(padRet("", "12"));
	}

	static void pad(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		int digit = up.charAt(0) - '0';
		for (int i = (digit - 1) * 3; i < digit * 3; i++) {
			char ch = (char) ('a' + i);
			pad(p + ch, up.substring(1));
		}
	}

	static ArrayList<String> padRet(String p, String up) {
		if (up.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(p);
			return list;
		}
		ArrayList<String> list = new ArrayList<>();
		int digit = up.charAt(0) - '0';
		for (int i = (digit - 1) * 3; i < digit * 3; i++) {
			char ch = (char) ('a' + i);
			list.addAll(padRet(p + ch, up.substring(1)));
		}

		return list;
	}

}
