package chapter5;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ChapterFiveA {
	
public static void main(String[] args) {
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario", "Milan");
	Trader alan = new Trader("Alan", "Cambridge");
	Trader brian = new Trader("Brian", "Cambridge");
	
	List<Transaction> transactions =  Arrays.asList(
	  new Transaction(brian, 2011, 300),
	  new Transaction(raoul, 2012, 1000),
	  new Transaction(raoul, 2011, 400),
	  new Transaction(mario, 2012,710),
	  new Transaction(mario, 2012,700),
	  new Transaction(alan, 2012, 950));
	
//Find all transactions in 2011 and sort by value.
	List<Transaction> tr2011 = 
			transactions.stream()
			.filter(transaction -> transaction.getYear()== 2011)
			.sorted(comparing(Transaction::getValue))
			.collect(toList());
	System.out.println(tr2011);
	
//What are all the unique cities where the traders work.
	List<String> cities = 
			transactions.stream()
			.map(transaction -> transaction.getTrader().getCity())
			.distinct()
			.collect(toList());
	System.out.println(cities);
	
//Dropping distinct() and using toSet() instead
	
 Set<String> cities1 = 
		 transactions.stream()
		 .map(transaction -> transaction.getTrader().getCity())
		 .collect(toSet());
 System.out.println(cities1);
 
// Find all traders from Cambridge and sort them by name
 List<Trader> traders = 
		 transactions.stream()
		 .map(Transaction::getTrader)
		 .filter(trader -> trader.getCity()== "Cambridge")
		 .distinct()
		 .sorted(comparing(Trader::getName))
		 .collect(toList());
 System.out.println(traders);
 
// String of all traders names sorted aphabetically
 
String traderStr = 
 transactions.stream()
 .map(transaction -> transaction.getTrader().getName())
 .distinct()
 .sorted()
 .reduce("", (n1, n2) -> n1 + n2);
System.out.println(traderStr);

// Are any traders based in Milan
boolean milanBased = transactions.stream()
               .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
System.out.println(milanBased);
 
// Print all transaction values from the traders living in Cambridge
transactions.stream()
.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
.map(Transaction::getValue)
.forEach(System.out::println);

// What is the highest value of all the transactions

Optional<Integer> highestValue = 
 transactions.stream()
 .map(Transaction::getValue)
 .reduce(Integer::max);
System.out.println(highestValue);

// Find the transaction with the smallest value
// (a)
Optional<Transaction> smallestTransaction =
 transactions.stream()
 .reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1: t2);
System.out.println(smallestTransaction);
	
// (b)
Optional<Transaction> smallestTransaction1 =
transactions.stream()
.min(comparing(Transaction::getValue));
System.out.println(smallestTransaction1);


//Primitive stream specializations
int allValues = transactions.stream()
               .mapToInt(Transaction::getValue)
               .sum();
System.out.println(allValues);

//Converting from a primitive stream to a general stream
IntStream intStream = transactions.stream()
                    .mapToInt(Transaction::getValue);
Stream<Integer> stream = intStream.boxed();
System.out.println(stream);

//Default values - optional int
//Find the maximum element of an Int stream by calling the max method
//which returns and OptionalInt
OptionalInt maxValues = transactions.stream()
              .mapToInt(Transaction::getValue)
              .max();
int max = maxValues.orElse(1);
System.out.println(max);

//Numeric ranges
//range closed includes start and end number
//rane excludes start and end numbers
IntStream evenNumbers = IntStream.rangeClosed(1, 100)
          .filter(n -> n % 2 == 0);
System.out.println(evenNumbers.count());
IntStream evenNumbers1= IntStream.range(1, 100)
.filter(n -> n % 2 == 0);
System.out.println(evenNumbers1.count());

}
}
