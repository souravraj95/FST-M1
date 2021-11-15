package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 7, 8, 3, 9, 10, 5 };
		System.out.println("Array before sorting: " + Arrays.toString(arr));
		sortAscending(arr);
		System.out.println("Array after sorting: " + Arrays.toString(arr));

	}

	public static void sortAscending(int[] data) {
		int size = data.length, i;

		for (i = 1; i < size; i++) {
			int key = data[i];
			int j = i - 1;

			while (j >= 0 && key < data[j]) {
				data[j + 1] = data[j];
				--j;
			}
			data[j + 1] = key;
		}
	}
}
