package recursion;

import java.util.ArrayList;

public class DiceThrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		dice("", 4);
//		System.out.println(diceRet("", 4));
		diceFace("", 4, 7);
	}

	static void dice(String p, int target) {
		if (target == 0) {
			System.out.println(p);
			return;
		}

		for (int i = 1; i <= 6 && i <= target; i++) {
			dice(p + i, target - i);
		}
	}

	static void diceFace(String p, int target, int face) {
		if (target == 0) {
			System.out.println(p);
			return;
		}

		for (int i = 1; i <= face && i <= target; i++) {
			diceFace(p + i, target - i, face);
		}
	}

	static ArrayList<String> diceRet(String p, int target) {
		if (target == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}

		ArrayList<String> list = new ArrayList<>();

		for (int i = 1; i <= 6 && i <= target; i++) {
			list.addAll(diceRet(p + i, target - i));
		}

		return list;
	}

}
