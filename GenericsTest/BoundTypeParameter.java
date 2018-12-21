package GenericsTest;

public class BoundTypeParameter {
	/*
	 * Bound type parameter <? extends foo>
	 * When you restrict classes to object inherited particular classes.
	 */
	public static void main(String[] args) {
		Bound<A> a = new Bound<A>(new A());
		a.classPrint();
		
		Bound<B> b = new Bound<B>(new B());
		b.classPrint();
		
		//Bound<C> c = new Bound<C>(new C()); This is an error because C is not a child of A class
		Bound<A> a2 = new Bound<A>(new B());
		a2.classPrint();
		
		//Bound<B> b2 = new Bound<B>(new A()); This is an error because B is child of A.
		Bound<A> b2 = new Bound<A>(new B());
		b2.classPrint();
		
		/*This below is an error because <A> and <B> are not parent and child.
		 *Bound<A> a3 = new Bound<B>(new B());
		 *You can do this below.
		 * */
		Bound<? extends A> b3 = new Bound<B>(new B()); 
		b3.classPrint();
		
	}
}


//Generic Method + bounded type parameter
class Bound<T extends A> {
	private T t;
	
	public Bound(T obj) {
		this.t = obj;
	}
	
	void classPrint() {
		System.out.println(this.t.getName());
	}
}

class A {
	private String name = "A";
	String getName() {
		return this.name;
	}
}

class B extends A {
	private String name = "B";
	String getName() {
		return this.name;
	}
}

class C {
	private String name = "C";
	String getName() {
		return this.name;
	}
}