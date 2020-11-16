public class BankAccount {

    private int balance;
    private String name;
    

    BankAccount(String name, int balance) {
	this.name = name;
	this.balance = balance;
    }

    public synchronized void deposit(int amount) {
	balance += amount;
        System.out.print(this.name + " made a deposit of "
			 + amount + ". ");
        System.out.println("The balance is now " + balance);
    }

    public synchronized void withdraw(int amount) {
	balance -= amount;
        System.out.print(this.name + " made a withdraw of "
                         + amount + ". ");
        System.out.println("The balance is now " + balance + ".");
    }

    public int getBalance() {
	return balance;
    }

    public static void main (String[] args) {
	BankAccount vesa = new BankAccount("vesa",1000);
	Thread thread1 = new accountThread(vesa, "Thread 1");
	Thread thread2 = new accountThread(vesa, "Thread 2");
	thread1.start();
	thread2.start();
    }
}

class accountThread extends Thread {
    
    private BankAccount localCopy;
    private String threadName;

    accountThread(BankAccount account, String name) {
	localCopy = account;
	threadName = name;
    }

    @Override
    public void run() {
	for (int i = 0; i < 10; i++) {
	    synchronized (localCopy) {
		System.out.print(threadName + ": ");
		int amount = (int) (Math.random() * 10 + 1);
		localCopy.deposit(amount);
		System.out.print(threadName + ": ");
		amount = (int) (Math.random() * 10 + 1);
		localCopy.withdraw(amount);
	    }
	}
    }   
}	
				  