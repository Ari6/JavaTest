package LambdaTest;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		/*
		 * R Function(T)
		 */
		Function<Integer, String> a = (i) -> { return Integer.toString(i * 100); };
		String result = a.apply(100);
		System.out.println(result + " type: " + result.getClass());
	}

}
