import java.util.*;
public class mergeTwoSortedLL{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        linkedList<Integer> ll1=new linkedList<>();
        System.out.println("enter the no of nodes for LL1:");
        int n=s.nextInt();
        System.out.println("enter the LL1 values:");
        for (int i=0; i<n; i++) {
            ll1.insertAtEnd(1);
        }
         linkedList<Integer> ll2=new linkedList<>();
        System.out.println("enter the no of nodes for LL2:");
        n=s.nextInt();
        System.out.println("enter the LL2 values:");
        for (int i=0; i<n; i++) {
            ll2.insertAtEnd(2);
        }
        System.out.print("linked list 1 elements are :");
        ll1.display(1);
        System.out.print("linked list 2 elements are :");
        ll2.display(2);
        linkedList<Integer> ll=new linkedList<>();
        System.out.print("merged sorted LL is: ");
        ll.merge();
        System.out.println(ll.head.data);
        ll.display(0);

    }
}
class linkedList<T>{
    node<Integer> head,head1,head2;
    static int count=0;

    void merge(){
        System.out.println(123);
        if(head1==null || head2==null){
            return;
        }
        System.out.println(123);
        node<Integer> anshead,anstail;
        if(head1.data<=head2.data){
            anshead=head1;
            anstail=head1;
            head1=head1.next;
        }else{
            anshead=head2;
            anstail=head2;
            head2=head2.next;
        }
        System.out.println(123);
         System.out.println(anshead.data);
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                anstail.next=head1;
                anstail=anstail.next;
                head1=head1.next;
            }else{
                anstail.next=head2;
                anstail=anstail.next;
                head2=head2.next;
            }
        }
        if(head1!=null){
            anstail.next=head1;
        }else if(head2!=null){
            anstail.next=head2;
        }
        head=anshead;

    }

    void  insertAtEnd(int z){
        if(z==1){
            head1=head;
        }else{
            head2=head;
        }
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

    void display(int z){
        if(z==1){
            head1=head;
        }else if(z==2){
            head2=head;
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


