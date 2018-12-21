package GenericsTest;

public class RawTypes {
	/*
	 * A raw type is the name of a generic class or interface without any type arguments.
	 */
	public static void main(String[] args) {
		//To create parameterized type
		Box<Integer> boxInstance1 = new Box<Integer>();
		boxInstance1.set(5);
		//actual type omitted. This is creation of raw type.
		//This is to be compatible with old versions.
		
		Box boxInstance2 = new Box(); //warning!!!
		boxInstance2.set(10); //warning!!!
		
		//You can assign parameterized type to raw but the opposite occurs warning.
		//This is because parameterized type instance has decided type already.
		Box boxInstance3 = new Box();
		Box<Integer> boxInstance4 = new Box();
		
		boxInstance3 = boxInstance1; 
		boxInstance4 = boxInstance2; //warning!!!
		
		//You can use other type
		Box<String> boxInstance5 = new Box();
		boxInstance5.set("String. Not Integer.");
		//boxInstance5.set(5); This is an error because you try to use Integer 
	}
}

class Box<T> {
	public void set(T t) {
		System.out.println(t);
	}
}
