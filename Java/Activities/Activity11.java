package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		HashMap<Integer,String> colours = new HashMap<Integer,String>();
		colours.put(1, "Red");
		colours.put(2, "Green");
		colours.put(3, "Blue");
		colours.put(4, "White");
		colours.put(5, "Black");
		
		System.out.println("Original HashMap: "+ colours);
		
		colours.remove(3);
		System.out.println("Map after removing color: "+ colours);
		
		if(colours.containsValue("Green")) {
			System.out.println("Green color exists in the Map");
		}else {
			System.out.println("Green color does not exist in the Map");
		}
		
		System.out.println("Number of pairs presents in Map: "+ colours.size());
		

	}

}
