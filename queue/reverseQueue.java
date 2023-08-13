import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class reverseQueue {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Queue<Integer> queue= new LinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        for(int i=0; i<n; i++) {
            int value = scanner.nextInt();
            queue.add(value);
        }
        solution.reverseQueue(queue);
        for(int i=0; i<n; i++){
            System.out.println(queue.poll());
        }
    }
}
class Solution {

	public static void reverseQueue(Queue<Integer> input) {
		Stack<Integer> stack=new Stack<>();
		while(!input.isEmpty()){
			stack.push(input.poll());
		}
		while(!stack.isEmpty()){
			input.add(stack.pop());
		}
		

		
	}

}