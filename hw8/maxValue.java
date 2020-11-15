public class maxValue {

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
	int min = 0;
	int max = 10000000;
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
	int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
	    if (max < s[i].getMax()) {
		max = s[i].getMax();
	    }
	}

	return max;
    }

    public static void main(String[] args) throws Exception {
	int[] arr = new int[40000];
	generateRandomArray(arr);
	int max = max(arr);
	System.out.println("Max: " + max);
    }
}

class maxThread extends Thread {
    private int[] arr;
    private int max;
    private int start, end;

    maxThread(int[] arr, int start, int end) {
	this.arr = arr;
	this.start = start;
	this.end = end;
    }

    private void max() {
	max = Integer.MIN_VALUE;
	for(int i = start; i < end; i++) {
	    if (arr[i] > max) {
		max = arr[i];
	    }
	}
    }
    
    public void run() {
	this.max();  
    }
    
    public int getMax() {
	return max;
    }
}