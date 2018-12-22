package GenericsTest;

import java.util.List;
import java.util.ArrayList;


//UU means Upper Unbounded.
public class UpperUnbounded {
	public static void main(String[] args) {
		UUA a = new UUA("A");
		UUB b = new UUB("B");
		UUC c = new UUC("C");
		
		//Test Box
		List<? extends UUA> testBox;
		//
		
		/*
		 * UUA
		 */
		List<UUA> listA = new ArrayList<>();
		listA.add(a);
		listA.add(b); 
		
		testBox = listA;
		System.out.println(testBox.get(0).getName());
		
		/*
		 * UUB
		 */
		List<UUB> listB = new ArrayList<>();
		//listB.add(a); //Error!!! you cannot assign child class to parent class.
		listB.add(b);
		
		testBox = listB;
		System.out.println(testBox.get(0).getName());
		
		/*
		 * UUC
		 */
		List<UUC> listC = new ArrayList<>();
		listC.add(c);
		
		//testBox = listC; //Error!!! Since C is not related with A
		//System.out.println(testBox.get(0).getName());
	}
}

class UUA {
	 private String name;
	 public UUA() {
		 this("None");
	 }
	 public UUA(String name) {
		 this.name = name;
	 }
	 
	 String getName(){
		 return name;		 
	 }
}

class UUB extends UUA{
	public UUB() {
		super();
	}
	public UUB(String name) {
		super(name);
	}
}

class UUC {
	private String name;
	
	public UUC() {
		this("NoneCCC");
	}
	
	public UUC(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
}