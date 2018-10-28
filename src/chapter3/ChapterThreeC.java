package chapter3;

public class ChapterThreeC extends Thread {
	
	public static void main(String...args) {
		
		Runnable r1 = () -> System.out.println("Hello World 1");
		process(r1);
		
		Runnable r2 = new Runnable() {
			public void run() {
				System.out.println("Hello World 2");
			}
		};
		process(r2);
		process(() -> System.out.println("Hello World 3"));
		process(() -> System.out.println("This is awesome!!"));
		}
		
			public static void process(Runnable r) {
			r.run();
		}
	
	
	

}
