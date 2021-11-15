package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strList = new ArrayList<>();
		
		strList.add("Otis");
		strList.add("Yash");
		strList.add("Bruno");
		strList.add("Shaila");
		strList.add("Meave");

		for(int i=0; i<strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("Third Element: " + strList.get(2));
		System.out.println(strList.contains("Otis"));
		System.out.println(strList.size());
		strList.remove("Meave");
		System.out.println(strList.size());
	}
	

}
