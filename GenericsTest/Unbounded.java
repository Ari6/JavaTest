package GenericsTest;
import java.util.List;
import java.util.ArrayList;

public class Unbounded {
	public static void main(String[] args) { 
		List<?> aList = new ArrayList<Integer>();
		aList.add(null); //You cannot add any object other than null.
		                 // aList.add(8); Error!!!!
	}

}
