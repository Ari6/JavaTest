package LambdaTest;

import java.util.Arrays;
import java.util.List;
//import java.util.ArrayList;

public class StreamLambda {
	public static void main(String[] args) {
		/*
		 * This is just sorting with stream. Integer implements Comparable.
		 */
		List<Integer> originalArray = Arrays.asList(null, 1000, 3, 8, -1, 5, 100, 99);
		originalArray.stream().filter(i -> i != null).sorted().forEach(System.out::println);
		
		
	}
}
