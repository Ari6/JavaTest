package GenericsTest;

public class GenericMethod {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<>(1, "January"); //<> you can use type inference 
		Pair<Integer, String> p2 = new Pair<>(2, "Feburuary");
		Pair<Integer, String> p3 = new Pair(1, "January"); //warning!!! because Pair should be parameterized.
		
		boolean answer = Compare.<Integer, String>compare(p1, p2);
		
		//This below is also legitimate because Java compiler automatically infers type.
		//From official document - 
		//     type inference, which enables you to invoke a generic method as you would an ordinary method, without specifying a type between angle brackets.
		boolean answerTypeInference = Compare.compare(p1, p2);
		
		boolean match = Compare.compare(p1, p3);
		
		System.out.println("p1:p2 " + answer);
		System.out.println("p1:p2 " + answerTypeInference);
		System.out.println("p1:p3 " + match);
	}	
}


class Compare{
	//This is how declare generic method. Put generics before 
	public static <K, V> boolean compare (Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && 
				p1.getValue().equals(p2.getValue());
	}
}

class Pair<K, V>{ //When you give a class generic information
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public void setKey(K key) { this.key = key; }
	public void setValue(V value) { this.value = value; }
	public K getKey() { return key; }
	public V getValue() { return value; }
	
}