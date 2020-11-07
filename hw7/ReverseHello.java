public class ReverseHello {

    public static void reverseThreadCall(int n, int i) throws Exception {
	if(n == 0) return;
	Thread newthread = new Thread(() -> { 
		try {
		    reverseThreadCall(n-1, i+1);
		} catch (Exception e) {	   
		
		}
	    });
	newthread.start();
	newthread.join();
	System.out.println("Hello from Thread " + i);
    }

    public static void main(String[] args) throws Exception {
	ReverseHello.reverseThreadCall(50,1);
    }

}

    