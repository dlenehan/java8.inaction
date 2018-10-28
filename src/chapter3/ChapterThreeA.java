package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChapterThreeA {
	
public static String processFile() throws IOException{
	try (
		BufferedReader br = new BufferedReader(new FileReader("/Users/lenehand/MyProjects/data.txt"))){
			return br.readLine();
		}
	}
	
	
public static void main(String[] args) {
	
	try {
	String line = processFile();
	System.out.println(line);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}


