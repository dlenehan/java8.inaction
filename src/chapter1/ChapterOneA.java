package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChapterOneA {

public static <T> List<T> filter(List<T> list, Predicate<T> p){
	List<T> results = new ArrayList<>();
	for(T s: list) {
		if(p.test(s)) {
			results.add(s);
		}
	}
	return results;
}
	
public static void main(String[] args) {

List<Apple> inventory = Arrays.asList(
		         new Apple("green",150),
		         new Apple("red",100),
		         new Apple("green",220),
		         new Apple("red",50));

List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColour()));

for(Apple apple: redApples) {
	System.out.println("Result: " + apple);
}
	
}
}
