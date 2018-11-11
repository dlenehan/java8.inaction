package chapter4;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;	

public class ChapterFourA {
	
public static void main(String[] args) {
	List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 100, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza",true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH));
	
// First example of java 8 streams.
	
	List<String> lowCaloricDishesName = 
			menu.stream()
			.filter(d -> d.getCalories() < 400)
			.sorted(comparing(Dish::getCalories))
			.map(Dish::getName)
			.collect(toList());
	
	System.out.println("These are the low calorie dishes: " + lowCaloricDishesName);
	
	
		
	List<String> threeHighCalorieDishNames = 
			menu.stream()
			.filter(d ->{System.out.println("filtering " + d.getName()); return d.getCalories()> 300	;})
//			.map(Dish::getName)
			.map(d -> {System.out.println("mapping " + d.getName());
			         return d.getName();
			})
			.limit(3)
			.collect(toList());

//	Internal iteration
	
	System.out.println(threeHighCalorieDishNames);
	
// Using terminal forEach operation
	menu.stream().forEach(System.out::println);

// Create a vegetarian menu by filtering all vegetarian dishes	
	List<Dish> vegetarianMenu = menu.stream()
			                    .filter(Dish::isVegetarian)
			                    .collect(toList());
	
	System.out.println(vegetarianMenu);
		
//	Filtering unique elements - using distinct method
	List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
	numbers.stream()
	.filter(i -> i % 2 == 0)
	.distinct()
	.forEach(System.out::println);
	
// Truncating a stream - using the limit method	
    List<Dish> dishesLimited = menu.stream()
    		.filter(d -> d.getCalories() > 300)
    		.limit(3)
    		.collect(toList());
    System.out.println("Using limit method: " + dishesLimited);
    
    
//	Skipping elements
	List<Dish> dishes = menu.stream()
			            .filter(d -> d.getCalories() > 300)
			            .skip(2)
			            .collect(toList());
	
	System.out.println("Using skip method: " + dishes);
	
//	Mapping
//	Given a list of words return a list of the number of characters for each word.
	List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
	List<Integer> wordLengths = words.stream()
		.map(String::length)
		.collect(toList());
	System.out.println("Number of characters in each word: " + wordLengths);
	
//Chaining maps
 List<Integer> dishNameLengths = menu.stream()
		                         .map(Dish::getName)
		                         .map(String::length)
		                         .collect(toList());
 
 System.out.println("Number of characters of the name of each dish on the menu: " + dishNameLengths);
 
// Flattening streams
 List<String> words1 = Arrays.asList("Hello", "World");
 List<String> uniqueCharacters =
		 words1.stream()
		 .map(w -> w.split(""))
		 .flatMap(Arrays::stream)
		 .distinct()
		 .collect(Collectors.toList());
	System.out.println(uniqueCharacters);
	
//anyMatch, allMatch, noneMatch use short circuiting - stream version of || and &&
//	Checking to see if a predicate matches at lease one element
if(menu.stream().anyMatch(Dish::isVegetarian)) {
	System.out.println("The menu is (somewhat) vegetarian friendly!!");
}
	
// Checking to see if a predicate matches all elements
boolean isHealthy = menu.stream()
                    .allMatch(d -> d.getCalories() < 1000);
System.out.println(isHealthy);


// Ensures no elements in the stream match the given predicate
boolean isSuperHealthy = menu.stream()
                        .noneMatch(d -> d.getCalories() >= 1000);
System.out.println(isSuperHealthy);

// Return an arbitrary element of the current stream
Optional<Dish> dishOpt = menu.stream()
     .filter(Dish::isVegetarian)
     .findAny();

System.out.println(dishOpt);

//Java.util.Optional has some methods available that force you to explicitly check for the 
//presence of a value or deal with its absence.
menu.stream()
.filter(Dish::isVegetarian)
.findAny()
.ifPresent(d -> System.out.println(d.getName()));

// For streams where you wish to find the first element.
List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
Optional<Integer> firstSquareDivisibleByThree = 
              someNumbers.stream()
              .map(x -> x * x)
              .filter(x -> x % 3 ==0)
              .findFirst();
System.out.println(firstSquareDivisibleByThree);

//Using reduce
List<Integer> moreNumbers = Arrays.asList(4,5,3,9);
int product = moreNumbers.stream()
             .reduce(0, (a,b) -> a + b);
System.out.println(product);
Optional<Integer> max = moreNumbers.stream().reduce(Integer::max);
System.out.println(max);;
Optional<Integer> min = moreNumbers.stream().reduce(Integer::min);
System.out.println(min);

    

}
}

