package chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ChapterFiveB {
	
public static void main(String[] args) {
	
//	Streams from values
//	Creating stream with explicit values using static method Stream.of
	
Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
stream.map(String::toUpperCase).forEach(System.out::println);

Stream<String> emptyStream = Stream.empty();
System.out.println(emptyStream);

//Streams from arrays
int[] numbers = {2,3,5,7,11,13};
int sum = Arrays.stream(numbers).sum();
System.out.println(sum);

//Streams from files
//Many static methods in java.nio.file.Files return a stream
//File.lines returns a stream of lines as strings from a given file

long uniqueWords = 0;
try(Stream<String> lines = 
Files.lines(Paths.get("/Users/lenehand/MyProjects/data.txt"), Charset.defaultCharset())){
	uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
			.distinct()
			.count();
}
catch(IOException e) {
	
}
System.out.println(uniqueWords);

//Streams from functions: creating infinite streams
//Streams produced from iterate and generate create values on demand given a function
//It's sensible to use a limit(n) on such streams to avoid printing an infinite number of values
//an infinite stream is called unbounded

Stream.iterate(0, n -> n+2)
.limit(10)
.forEach(System.out::println);

//Generate
//Takes a lambda of type Supplier<T> to provide new values

Stream.generate(Math::random)
.limit(5)
.forEach(System.out::println);

}

}
