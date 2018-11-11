package chapter5;

public class Trader {
	
private final String name;
private final String city;

@Override
public String toString() {
	return "Trader:"+this.name + " in " + this.city;
}

public String getName() {
	return name;
}

public String getCity() {
	return city;
}

public Trader(String name, String city) {
	super();
	this.name = name;
	this.city = city;
}


}
