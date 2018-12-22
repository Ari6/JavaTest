package LambdaTest;

import java.util.function.Consumer;

public class LabmdaInMethod {
	public static void main(String[] args) {
		method(() -> {System.out.println("Labmda from method's augument.");});
		method2((s) -> { System.out.println(s);});
	}
	
	static void method(Runnable r){
		r.run();
	}
	
	static void method2(Consumer<String> c) {
		c.accept("Hello");
	}
}	
