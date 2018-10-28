package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChapterThreeD {
	
	
public static <T> List<T> filter(List<T> list, Predicate<T> p){
	List<T> results = new ArrayList<>();
	for(T s: list) {
		if(p.test(s)) {
			results.add(s);
		}
	}
	return results;
}


public static void main (String[] args) {
	
	List<String> theList = Arrays.asList("this", "is", "the", "best");
	Predicate<String> thePredicate = (String s) -> "best".equals(s);
	List<String> answer = filter(theList, thePredicate);
	System.out.println(answer);
	
}

}
