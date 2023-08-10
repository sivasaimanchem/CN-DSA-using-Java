import java.util.Scanner;

public class swapTwoNodesOfLL {
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
        ll.swap();
        ll.display();
    }
}
class linkedList<T>{
    node<Integer> head;
    int count=0;
    void swap(){
        Scanner s=new Scanner(System.in);
        System.out.println("enter values to get swapped");
        int a=s.nextInt();
        int b=s.nextInt();
        int count=0;
        node<Integer> curr=head,prev=null,firstnodecurr=null,lastnodecurr=null,firstnodeprev=null,lastnodeprev=null;
        while(curr!=null){
            if(count==a){
                firstnodecurr=curr;
                firstnodeprev=prev;
            }
            if(count==b){
                lastnodecurr=curr;
                lastnodeprev=prev;
            }
            prev=curr;
            curr=curr.next;
            count++;
        }
        if(firstnodeprev!=null){
            firstnodeprev.next=lastnodecurr;
        }else{
            head=lastnodecurr;
        }
        if(lastnodeprev!=null){
            lastnodeprev.next=firstnodecurr;
        }else{
            head=firstnodecurr;
        }
        node<Integer> temp=lastnodecurr.next;
        lastnodecurr.next=firstnodecurr.next;
        firstnodecurr.next=temp;

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
