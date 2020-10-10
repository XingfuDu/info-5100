import java.util.PriorityQueue;
public class kthelement {
    
    public int findKthLargest(int[] nums, int k) {

        if (nums.length < k) {
            return -1;
        }
    
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }
    
        int x=-1;
        for(int i=0; i<k && !pq.isEmpty(); i++) {
           x = pq.remove();
        }
        return x;
    }
}
