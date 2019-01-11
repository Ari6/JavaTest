package basics;

import java.util.ArrayList;
import java.util.List;

class ArrayTest {
	public static void main(String[] args) {
		List<Employee> arrayEmployee1 = new ArrayList<Employee>();
		Employee a = new Manager(0,"Alice", 30, 5000);
		Employee b = new Employee(1, "Bob", 24, 1000);
		arrayEmployee1.add(a);
		arrayEmployee1.add(b);
		a.setSalary(50000);
		Manager c = (Manager)a;
		c.setBonus(25000);
		Tool.printTool(a);
		Tool.printTool((Manager)arrayEmployee1.get(0));
		Tool.printTool(b);
		Tool.printTool(arrayEmployee1.get(1));
		
		System.out.println("++++++++Foreach++++++++++");
		for(Employee e : arrayEmployee1) {
			Tool.printTool(e);
		}

		//Stream
		System.out.println("++++++++Stream+++++++++++");
		arrayEmployee1.stream().forEach(Tool::printTool);


	}
}

