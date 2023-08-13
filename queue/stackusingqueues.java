import java.util.*;
public class stackusingqueues{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Stack S=new Stack();
        boolean a=true;
        while(a){
            System.out.println("enter the option number of the requried operation:");
            int n=s.nextInt();
            switch (n){
                case 0:
                    int val=s.nextInt();
                    S.push(val);
                    break;
                case 1:
                    System.out.println(S.pop());
                    break;
                case 2:
                    System.out.println(S.size());
                    break;
                case 3:
                    System.out.println(S.isEmpty());
                    break;
                case 4:
                    System.out.println(S.top());
                    break;
                case 5:
                    a=false;
                    break;
                default:
                    System.out.println("choose valid option");
            }
        }
        
    }
}
class Stack{
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public Stack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int data) {
        queue1.add(data);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            return -1;
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int poppedElement = queue1.remove();

        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;

        return poppedElement;
    }

    public int top() {
        if (queue1.isEmpty()) {
            return -1;
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int topElement = queue1.peek();

        queue2.add(queue1.remove());

        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;

        return topElement;
    }

    public int size() {
        return queue1.size();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}