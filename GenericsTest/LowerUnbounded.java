package GenericsTest;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * A <- B <- C
 */
//LU means Lower Unbounded.
public class LowerUnbounded {
	public static void main(String[] args) {
		/*
		 * a box for assign check
		 */
		List<? super LUB> testBox;
		
		/*
		 * LUA
		 */
		List<LUA> listA = new ArrayList<LUA>();
		listA.add(new LUA("A"));
		listA.add(new LUB("B"));
		listA.add(new LUC("C"));		

		testBox = listA;
		System.out.println(((LUA) testBox.get(0)).getName());
		//System.out.println(testBox.get(0).getName()); //I do not why this does not work.
		
		/*
		 * LUB
		 */
		List<LUB> listB = new ArrayList<>();
		//listB.add(new LUA("A")); //You cannot do this.
		listB.add(new LUB("B"));
		
		testBox = listB;
		System.out.println(((LUB)testBox.get(0)).getName());
		
		/*
		 *  LUC
		 */
		List<LUC> listC = new ArrayList<>();
		listC.add(new LUC("C"));
		
		//testBox = listC; this does not work because C is a child of B.(is not B's a parent(super).
		
	}
}

class LUA {
	 private String name;
	 public LUA() {
		 this("None");
	 }
	 
	 public LUA(String name) {
		 this.name = name;
	 }
	 
	 void setName(String name){
		 this.name = name;
	 }
	 
	 String getName() {
		 return this.name;
	 }
}

class LUB extends LUA{
	public LUB() {
		super();
	}
	public LUB(String name) {
		super(name);
	}
}

class LUC extends LUB {
	public LUC() {
		super();
	}
	
	public LUC(String name) {
		super(name);
	}
}