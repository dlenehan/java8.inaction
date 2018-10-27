package chapter2;


public class AppleFancyFormatter implements AppleFormatter{
	
	public String accept(Apple a) {
		String characteristic = a.getWeight() > 150 ? "heavy"
 : "light";
	return "A " + characteristic + " " + a.getColour() + " apple";
	 
	}
	

}
