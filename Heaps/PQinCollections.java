import java.util.PriorityQueue;

public class PQinCollections {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int arr[]={2,3,6,5,8,4,9,13,11};
        for (int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i=0; i<arr.length; i++) {
            Integer val=pq.peek();
            System.out.print(val+" ");
            pq.poll();
        }
    }
}
