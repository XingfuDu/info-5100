public class SumValue {

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
	int min = 0;
	int max = 100;
	for(int i = 0; i < arr.length; i++) {
	    arr[i] = (int)(Math.random() * (max - min + 1) + min);
       	}
    }
    /*get sum of an array using 4 threads*/
    static long sum(int[] arr) throws Exception {
	sumThread[] s = new sumThread[4];
	for (int i = 0; i < 4; i++) {
	    int len = arr.length / 4;
	    s[i] = new sumThread(arr, i * len, i * len + len);
	    s[i].start();
	    s[i].join();
	}
	long res = 0;
        for (int i = 0; i < 4; i++) {
	    res += s[i].getSum();
	}

	return res;
    }

    public static void main(String[] args) throws Exception {
	int[] arr = new int[40000];
	generateRandomArray(arr);
	long sum = sum(arr);
	System.out.println("Sum: " + sum);
    }
}

class sumThread extends Thread {
    private int[] arr;
    private long sum;
    private int start, end;

    sumThread(int[] arr, int start, int end) {
	this.arr = arr;
	this.start = start;
	this.end = end;
    }

    private void sum() {
	for(int i = start; i < end; i++) {
	    sum += arr[i];
	}
    }
    
    public void run() {
	this.sum();  
    }
    
    public long getSum() {
	return sum;
    }
}