import java.util.*;
public class EvenafterOddLinkedList{
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
        ll.evenOdd();
        System.out.println("list elments after even-odd separation are:"); 
        ll.display();
    }
}
class linkedList<T>{
    node<Integer> head;
    static int count=0;

    void evenOdd(){
        if(head==null || head.next==null){
            return;
        }
        node<Integer> temp=head,eh=null,et=null,oh=null,ot=null;
        while(temp!=null){
            if(temp.data%2==0){
                if(eh==null){
                    eh=temp;
                    et=temp;
                }
                else{
                    et.next=temp;
                    et=et.next;
                }

            }else{
                if(oh==null){
                    oh=temp;
                    ot=temp;
                }
                else{
                    ot.next=temp;
                    ot=ot.next;
                }
            }
            temp=temp.next;
        }
        et=null;
        ot.next=eh;
        head=oh;

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
