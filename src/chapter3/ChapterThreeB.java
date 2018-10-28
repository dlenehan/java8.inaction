package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ChapterThreeB {
	
	public static String processFile(BufferedReaderProcessor p)
			throws IOException{
		try (BufferedReader br = 
	new BufferedReader(new FileReader("/Users/lenehand/MyProjects/data.txt"))){
			return p.process(br);
		}
	}

	
	
public static void main(String[] args) {

	try {
		String oneline = processFile((BufferedReader br)-> br.readLine());
		System.out.println(oneline);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		String twoline = processFile((BufferedReader br)-> br.readLine()
				+ " " + br.readLine());
		System.out.println(twoline);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	



	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
