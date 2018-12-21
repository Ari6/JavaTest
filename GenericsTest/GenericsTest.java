package GenericsTest;

public class GenericsTest {
	public static void main(String[] args) {
		/*
		 * This is memo from Java Complete Reference.
		 * Generics means "parameterized types". I understand that this means you can use types as if variables.
		 * 
		 * */
		
		Gen<Integer> intOb = new Gen<Integer>(88); //Gen with Integer
		intOb.showType();
		
		int intValue = intOb.getob();
		System.out.println("Value: " + intValue);
		
		Gen<String> strOb = new Gen<String>("Test"); //Gen with String
		strOb.showType();
		
		String strValue = strOb.getob();
		System.out.println("Str Value: " + strValue);
	}
}

/* T(Type parameter) will be replaced particular type when you declare variables as Generics.
 * ** List<String> or Box<Integer>=> parameterized type 
 * You cannot get type parameter name because it is replaced. See above Gen<xxx>
 * E - Element (used extensively by the Java Collections Framework)
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 * S,U,V etc. - 2nd, 3rd, 4th types
 */ 

class Gen<T>{
	T ob;
	
	Gen(T o){
		ob = o;
	}
	T getob() {
		return ob;
	}
	void showType() {
		System.out.println("Type T: " + ob.getClass().getName());
	}
}

