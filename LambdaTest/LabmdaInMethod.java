package LambdaTest;

import java.util.function.Consumer;

public class LabmdaInMethod {
	public static void main(String[] args) {
		/*
		 * To use Lambda expression as method's augments.
		 */
		
		method(() -> {System.out.println("Labmda from method's augment.");});
		method2((s) -> { System.out.println(s);});
	}
	
	static void method(Runnable r){
		r.run();
	}
	
	static void method2(Consumer<String> c) {
		c.accept("Hello");
	}
}	
