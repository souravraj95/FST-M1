package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 10, 77, 10, 54, -11, 10 };

		int search = 10;
		int finalNo = 30;

		System.out.println("Results: " + result(num, search, finalNo));

	}

	public static boolean result(int[] numbers, int search, int finalNo) {

		int temp = 0;

		for (int number : numbers) {
			if (number == search) {
				temp += search;
			}

			if (temp > finalNo) {
				break;
			}
		}
		if (temp == finalNo) {
			return true;
		} else {
			return false;
		}

	}

}
