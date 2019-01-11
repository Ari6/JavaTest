package basics;

public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager a = new Manager(0,"Alice", 30, 5000);
		Employee b = new Employee(1, "Bob", 24);
		Employee c = a;
		Manager d = (Manager) c;
		//basics.Manager e = (basics.Manager) b; This doesn't work since b has been instantiated as basics.Employee (as a parent) at the beggining
		a.setBonus(10000);
		//a.getLastId();
		//b.getLastId();
		c.name = "Ariel";
		Tool.printTool(a);
		Tool.printTool(b);
		Tool.printTool(c); //c's actual class is basics.Manager but instance(box) is basics.Employee. So it does not show salary but class is basics.Manager.
		Tool.printTool(d); //This is basics.Manager a -> basics.Employee c -> basics.Manager a. This instance can hold basics.Manager's field after casted basics.Employee
		//basics.Tool.printTool(e);
		
		System.out.println("+++++Even type is a Super class, method works actual instance class.+++++");
		//This means that you can over ride methods but if declared only in subclass, you cannot use them.
		Employee a2 = new Manager(0, "Alice", 30);
		Employee b2 = new Employee(1, "Bob", 24);
		a2.setSalary(9999); // set salary to basics.Manager's Salary
		b2.setSalary(9999); // do nothing.
		System.out.println(a2.name + ":" + a2.salary);
		System.out.println(b2.name + ":" + b2.salary);
		System.out.println(b2.equals(a2));
	}
}

class Tool{
	public static void printTool(Employee a) {
		System.out.println(a.getClass() + ":" + a.id + ":" + a.name + ":" + a.age + ":" + a.salary);
	}
	public static void printTool(Manager a) {
		System.out.println(a.getClass() + ":" +a.id + ":" + a.name + ":" + a.age + ":" + a.salary + ":" + a.bonus);
	}
}

class Employee {
	int id;
	String name;
	int age;
	int salary;
	public static int lastId = 0;
	
	Employee(){
	}
	Employee(int id){
		this(id, "John Doe", 0, 0);
	}
	Employee(int id, String n){
		this(id, n, 0, 0);
	}
	Employee(int id, String n, int a) {
		this(id, n, a, 0);
	}
	
	Employee(int id, String n, int a, int s){
		this.id = id;
		this.name = n;
		this.age = a;
		this.salary = s;
	}
	
	String getName() {
		return this.name;
	}
	int getAge() {
		return this.age;
	}
	int getLastId() {
		return lastId++;
	}
	
	void setSalary(int salary) { }
	public static void printTool(Employee a) {
		System.out.println(a.getClass() + ":" + a.id + ":" + a.name + ":" + a.age + ":" + a.salary);
	}
}

class Manager extends Employee{
	int bonus = 0;
	
	Manager(int id){
		super(id);
	}
	Manager(int id, String name){
		super(id, name);
	}
	Manager(int id, String name, int age){
		super(id, name, age, 0);
	}
	Manager(int id, String name, int age, int salary){
		super(id, name, age, salary);
	}
	/*basics.Manager(int id, String name, int age, int salary, int bonus){
		super(id, name, age, salary);
		this.bonus = bonus;
	}*/
	int getBonus() {
		return this.bonus;
	}
	void setBonus(int a) { this.bonus = a;}
	void setSalary(int salary) {
		this.salary = salary;
	}
	public static void printTool(Manager a) {
		System.out.println(a.getClass() + ":" + a.id + ":" + a.name + ":" + a.age + ":" + a.salary + ":" + a.bonus);
	}
}