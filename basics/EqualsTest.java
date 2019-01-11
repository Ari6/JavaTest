package basics;

import java.util.Objects;

public class EqualsTest {
	public static void main(String[] args) {
		Manager a = new Manager(0,"Alice", 30, 5000);
		Employee b = new Employee(1, "Bob", 24,1000);
		Contructor c = new Contructor(2, "Sam", 35, 0, 15);

		Manager e = a;
		System.out.println("a:d " + a.equals(e)); // compare with the same object as basics.Manager and basics.Employee
		System.out.println("a:e " + a.equals(e)); // compare with the same object as basics.Manager and basics.Manager
		Employee f = b;	
		//basics.Manager g = (basics.Manager) b; cannot cast to subclass
		System.out.println("b:f " + b.equals(f)); // compare with the same object as basics.Employee and basics.Employee
		//System.out.println(b.equals(g)); // compare with the same object as basics.Manager and basics.Employee
		System.out.println("Super b:c " + Objects.equals(b, c));
	}
}
/* basics.Contructor class is bad idea since this breaks is-a relationship with basics.Employee.
 * Core Java Volume I chapter reference 5.8
 */
	class Contructor extends Employee{
		int wage;
		Contructor(int id, String name, int age, int salary, int wage){
			super(id, name, age, 0);
			this.wage = wage;
		}
	}
/*	private void printTool(basics.Employee a) {
		System.out.println(a.getClass() + ":" + a.id + ":" + a.name + ":" + a.age + ":" + a.salary);
	}*/
