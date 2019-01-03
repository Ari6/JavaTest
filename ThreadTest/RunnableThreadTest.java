package ThreadTest;

public class RunnableThreadTest implements Runnable{
	private String name;
	
	public RunnableThreadTest(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		var r1 = new RunnableThreadTest("R1");
		var r2 = new RunnableThreadTest("R2");

		var th1 = new Thread(r1);
		var th2 = new Thread(r2);
		th1.start();
		th2.start();
	}
	
	
	public void run() {
		var a = new Account();
		for (int i = 0; i < 10; i++) {
				a.deposit(1000);
				a.showBalance();
		}
	}
}

class Account{
	private int balance = 0;
	synchronized public void deposit(int money) {		
		int total = balance + money;
		
		try {
			Thread.sleep((long)(Math.random() * 1000));
		} catch (InterruptedException e) {}
		
		balance = total;
	}
	public void showBalance() {
		System.out.println("Current amount: " + balance);
	}
}
