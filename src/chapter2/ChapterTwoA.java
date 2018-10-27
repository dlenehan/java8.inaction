package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChapterTwoA {

	public static List<Apple> filter(List<Apple> inventory,
            ApplePredicate p){

List<Apple> result = new ArrayList<>();
for(Apple apple: inventory) {
if(p.test(apple)) {
result.add(apple);
}
}
return result;
}

public static void main(String[] args) {

List<Apple> inventory = Arrays.asList(
new Apple("green",160),
new Apple("red",100),
new Apple("green",100),
new Apple("red",200));

List<Apple> redAndHeavyApples = filter(inventory, 
new AppleRedAndHeavyPredicate());

for (Apple apple: redAndHeavyApples) {
System.out.println("Result: " +apple);
}


}
	
	
	
	
	
}
