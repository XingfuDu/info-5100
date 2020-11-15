import java.util.Arrays;
public class maxValue2 {

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
	int min = 0;
	int max = 100000;
	for(int i = 0; i < arr.length; i++) {
	    arr[i] = (int)(Math.random() * (max - min + 1) + min);
	    //System.out.print(arr[i] + " ");
       	}
	//System.out.println();
    }
    /*get sum of an array using 4 threads*/
    static int max(int[] arr) throws Exception {
	maxThread[] s = new maxThread[4];
	for (int i = 0; i < 4; i++) {
	    int len = arr.length / 4; 
	    s[i] = new maxThread(arr, i * len, i * len + len);
	    s[i].start();
	    s[i].join();
	}
       
	int max = maxThread.getMax();

	return max;
    }

    public static void main(String[] args) throws Exception {
	int[] arr = new int[400];
	generateRandomArray(arr);
	int max = max(arr);
	System.out.println("Max: " + max);
	Arrays.sort(arr);
	System.out.println("Max by sort: " + arr[arr.length - 1]);
    }
}


class maxThread extends Thread {
    private int[] arr;
    private int start;
    private int end;
    private static int max = Integer.MIN_VALUE;
    private final Object lock = new Object();

    maxThread(int[] arr, int start, int end) {
	this.arr = arr;
	this.start = start;
	this.end = end;
    }

    private void max() {
	for(int i = start; i < end; i++) {
	    synchronized(lock) {
		if (arr[i] > max) {
		    max = arr[i];
		}
	    }
	}
    }
    
    @Override
    public void run() {
	this.max();  
    }
    
    public static int getMax() {
	return max;
    }
    
}