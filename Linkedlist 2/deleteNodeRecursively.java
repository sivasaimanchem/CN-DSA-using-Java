import java.util.*;
public class deleteNodeRecursively {
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
        System.out.println("enter the position to delete:");
        int pos=s.nextInt(); 
        ll.delete(pos);
        System.out.println("list elements after deleting the node using recursion");
        ll.display();
    }
}
class linkedList<T>{
    node<Integer> head;
    static int count=0;
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

    void delete(int value){
        node<Integer> temp=head;
        deleteHelper(temp,value);
    }
    void deleteHelper(node<Integer> temp,int pos){
        if(temp==null || temp.next==null){
            return;
        }
        if(pos==1){
            temp.next=temp.next.next;
        }
        deleteHelper(temp.next, pos-1);
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
