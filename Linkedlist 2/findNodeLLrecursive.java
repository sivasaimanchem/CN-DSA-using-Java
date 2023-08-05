import java.util.*;
public class findNodeLLrecursive{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        linkedList<Integer> ll=new linkedList<>();
        System.out.println("enter the no of nodes for LL1:");
        int n=s.nextInt();
        System.out.println("enter the LL values:");
        for (int i=0; i<n; i++) {
            ll.insertAtEnd();
        }
        System.out.print("linked list  elements are :");
        ll.display();
        System.out.println("enter the falue to be found:");
        int value=s.nextInt();
        ll.find(value);

    }
}
class linkedList<T>{
    node<Integer> head,head1,head2;
    static int count=0;

    void find(int value){
        findHelper(value,head);

    }
    void findHelper(int value, node<Integer> currhead){
        if(currhead==null){
            System.out.println("value not found");
            return;
        }
        if(currhead.data==value){
            System.out.println("value found");
            return;
        }
        findHelper(value,currhead.next);
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
