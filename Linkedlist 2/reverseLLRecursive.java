import java.util.*;
public class reverseLLRecursive {
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
        ll.reverse();
        System.out.println("list elements after reversing the LL");
        ll.display();
    }
}
class linkedList<T>{
    node<Integer> head;
    static int count=0;

    void reverse(){
       head = reverseHelper(head);

    }
    node<Integer> reverseHelper(node<Integer> head){
        if(head==null || head.next==null){
            return head;
        }
        node<Integer>smallhead=reverseHelper(head.next);
        node<Integer>tail=head.next;
        tail.next=head;
        head.next=null;
        return smallhead;
    }

    void  insertAtEnd(){
        Scanner s=new Scanner(System.in);
        System.out.println("enter  the  value to be inserted");
        int value=s.nextInt();
        node<Integer> newnode=new node<>(value);
        if(head==null){
            head=newnode;
            count++;
            return;
        }
        node<Integer> temp=head;
        while(temp.next!=null){
            temp=temp.next;
        } 
        temp.next=newnode;
        count++;
    }

    void display(){
        if(head==null){
            return;
        }
        node<Integer> temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
class node<T>{
    T data;
    node<T> next;
    node(T data){
        this.data = data;
    }

}
