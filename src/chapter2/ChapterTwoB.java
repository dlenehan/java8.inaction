package chapter2;

import java.util.Arrays;
import java.util.List;


public class ChapterTwoB {
	
	public static void prettyPrintApple(List<Apple> inventory,
	        AppleFormatter f){
	for (Apple apple: inventory) {
		String output = f.accept(apple);
		System.out.println(output);
	}
		
	}
	
	
		
public static void main(String[] args) {

List<Apple> inventory = Arrays.asList(
new Apple("green",160),
new Apple("red",100),
new Apple("green",100),
new Apple("red",200));


prettyPrintApple(inventory, new AppleFancyFormatter());
prettyPrintApple(inventory, new AppleSimpleFormatter());

}
}
	
	
	
