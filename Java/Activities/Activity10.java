package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		Set<String> hs = new HashSet<>();
		
		hs.add("A");
		hs.add("B");
		hs.add("C");
		hs.add("D");
		hs.add("E");
		hs.add("F");
		
		System.out.println("Original HashSet: "+ hs);
		System.out.println("Size of HashSet: "+ hs.size());
		System.out.println("Remove element from HashSet: "+ hs.remove("E"));
		
		if(hs.remove("S")) {
			System.out.println("S removed from the Set");
		}else {
			System.out.println("S is not present in the Set");
		}
		
		System.out.println("Checking if B is present or not: "+ hs.contains("B"));
		System.out.println("Updated hashSet: "+ hs);
		

	}

}
