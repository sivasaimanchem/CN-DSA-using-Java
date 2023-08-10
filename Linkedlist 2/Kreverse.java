import java.util.Scanner;

public class Kreverse {
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
        System.out.println("enter the K value");
        int a=s.nextInt();
        ll.reverse(ll.head,a);
        ll.display();
    }
}
class linkedList<T>{
    node<Integer> head;
    int count=0;

    node<Integer> reverse(node<Integer> head, int k){
        if(k==0 || k==1){
            return head;
        }
        node<Integer> curr=head,fwd=null,prev=null;
        int count=0;
        while(count<k && curr!=null){
            fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
            count++;
        }
        //curr.next=prev;
        if(fwd!=null){
            head.next=reverse(fwd,k);
        }
        return prev;
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
