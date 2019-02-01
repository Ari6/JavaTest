package basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Dog[] dogs = new Dog[3];
		dogs[0] = new Dog("Doggie", 10);
		dogs[1] = new Dog("Kity", 15);
		dogs[2] = new Dog("kity", 25);

		Arrays.stream(dogs).sorted(Comparator.comparing(Dog::getNameLength)
				.thenComparing(Comparator.comparing(Dog::getAge).reversed()))
				.map(Object::toString)
				.forEach(System.out::println);
		Arrays.stream(dogs).forEach(System.out::println);
	}

}

class Dog {
	String name;
	int age;

	public Dog(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}
	public int getNameLength() { return this.name.length(); }

	public int getAge() {
		return this.age;
	}

	public String toString(){
		return "name: " + this.name + " age: " + this.age;
	}
}

