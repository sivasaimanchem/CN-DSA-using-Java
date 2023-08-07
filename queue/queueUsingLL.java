import java.util.*;
public class queueUsingLL {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        operations op=new operations();
        boolean a=true;
        while(a){
            System.out.println("enter the option number of the requried operation:");
            int n=s.nextInt();
            switch (n){
                case 0:
                    op.enqueue();
                    break;
                case 1:
                    op.dequeue();
                    break;
                case 2:
                    op.size();
                    break;
                case 3:
                    op.isEmpty();
                    break;
                case 4:
                    op.front();
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

class operations {
	
	//Define the data members
	private Node front;
	private Node rear;
	private int size;


	public operations() {
		//Implement the Constructor
	    front=null;
		rear=null;
	}
	


	/*----------------- Public Functions of Stack -----------------*/


	public void size() { 
		//Implement the getSize() function
		System.out.println(size);
    }


    public void isEmpty() { 
    	//Implement the isEmpty() function
		if(front==null){
			System.out.println("true");
		}
		else
		  System.out.println("false");
    }


    public void enqueue() {
    	//Implement the enqueue(element) function
        Scanner s = new Scanner(System.in);
        System.out.println("enter the value to be instred:");
        int value=s.nextInt();
        Node newNode= new Node(value);
		if(front ==null){
			front=newNode;
			rear=newNode;
			size++;
		}
		else{
		rear.next=newNode;
		size++;
		//System.out.println(size);
		rear=newNode;
		}
		
    }


    public void dequeue() {
    	//Implement the dequeue() function
		if(front == null){
			System.out.println("empty queue");
            return;
		}
		int temp=front.data;
		front=front.next;
		size--;

		System.out.println(temp);
    }


    public void front() {
    	//Implement the front() function
		if(front==null){
			System.out.println("null");
		}
		System.out.println(front.data);
    }
}


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}