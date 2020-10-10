public class Testkthelement {
    public static void main(String[] args) {
	int[] array = new int[]{3, 2, 1, 5, 6, 4};
	int k = 2;
	kthelement ke = new kthelement();
	System.out.println(ke.findKthLargest(array,k));

	array = new int[]{3,2,3,1,2,4,5,5,6};
	k = 4;
        System.out.println(ke.findKthLargest(array,4));

    }
}