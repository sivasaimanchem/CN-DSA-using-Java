import java.util.Scanner;

public class printReverse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        linkedList<Integer> ll=new linkedList<>();
        System.out.println("enter the no of nodes:");
        int n=s.nextInt();
        System.out.println("enter the node values:");
        for (int i=0; i<n; i++) {
            ll.insertAtEnd();
        }
        System.out.println("linked list elements are ");
        ll.display();
        System.out.println("list elements in reverse order");
        ll.reverse();
        
        //ll.display();
    }
}
class linkedList<T>{
    node<Integer> head;
    static int count=0;
    void insertAtEnd(){
        Scanner s=new Scanner(System.in);
        System.out.println("enter a value to insert:");
        int value = s.nextInt();
        node<Integer> curnode=new node<>(value);
        if(head == null){
            curnode.data=value;
            head=curnode;
            System.out.println("data inserted successfully");
            count++;
            return;
        }
        node<Integer> temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=curnode;
        count++;
    }

    void display(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        node<Integer> temp= head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        //System.out.println("list was sucessfully printed");

    }
    void reverse(){
        node<Integer> temp=head;
        reverseHelper(temp);

    }
    void reverseHelper(node<Integer> temp){
        if(temp==null){
            return;
        }
        reverseHelper(temp.next);
        System.out.print(temp.data+" ");
    }
}

class node<T>{
    T data;
    node<T> next;
    node(T data) {
        this.data=data;
    }
}
