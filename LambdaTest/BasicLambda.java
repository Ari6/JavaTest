package LambdaTest;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Arrays;

public class BasicLambda {

	public static void main(String[] args) {
		/*
		 * Runnable is an interface that has run() to make thread.
		 */
		Runnable a = () -> {System.out.println("Lambda"); };
		a.run();
		
		/*
		 * with argument
		 * Consumer provides generics that you can decide argument type.
		 * void accept(T);
		 */
		
		Consumer<Integer> b = (i) -> { System.out.println(i + 100); };
		b.accept(15);
		
		/* with argument and return value
		 * Function provides generics that you can decide argument and return value type.
		 */
		Function<Integer, String> c = (i) -> {
										String d = "String : " + i;
										return d;};
		System.out.println(c.apply(200));
	}

}
