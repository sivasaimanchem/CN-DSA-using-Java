import java.util.*;
public class LinkedListFunctions {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        linkedList<Integer> ll=new linkedList<>();
        int flag=1;
        while(flag != 11){

            System.out.println("Linked List Operations:");
            System.out.println("0. insertAtBeginning"); //O(1)
            System.out.println("1. insertAtEnd");//O(n)
            System.out.println("2. insertAtPosition");//O(n)
            System.out.println("3. replaceValue");//O(n)
            System.out.println("4. deleteAtBeginning");//O(1)
            System.out.println("5. deleteAtEnd");//O(n)
            System.out.println("6. deleteAtPosition");//O(n)
            System.out.println("7. deleteValue");//O(n)
            System.out.println("8. search");//O(n)
            System.out.println("9. count");//O(n)
            System.out.println("10. Display");//O(n)
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            flag = s.nextInt();

            switch(flag){
                case 0:
                    ll.insertAtBeginning();
                    break;
                case 1:
                    ll.insertAtEnd();
                    break;
                case 2:
                    ll.insertAtPosition();
                    break;
                case 3:
                    ll.replaceValue();
                    break;
                case 4:
                    ll.deleteAtBeginning();
                    break;
                case 5:
                    ll.deleteAtEnd();
                    break;
                case 6:
                    ll.deleteAtPosition();
                    break;
                case 7:
                    ll.deleteValue();
                    break;
                case 8:
                    ll.search();
                    break;
                case 9:
                    ll.count();
                    break;
                case 10:
                    ll.display();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invaild choice");

            }
        }
    }
}

class linkedList<T>{
    node<Integer> head;
    static int count;
    linkedList(){
        this.head = null;
    }
    void insertAtBeginning(){
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
        curnode.data=value;
        node<Integer> temp=head;
        curnode.next=temp;
        head=curnode;
        System.out.println("data inserted successfully");
        count++;

    }

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
    
    void insertAtPosition(){
        Scanner s=new Scanner(System.in);
        if(head==null){
            System.out.println("list is empty");
        }
        System.out.println("enter the position:");
        int pos=s.nextInt();
        System.out.println("enter the value to be inserted");
        int value=s.nextInt();
        node<Integer> curnode=new node<>(value);
        node<Integer> pre=head,post;
        int cnt=0;
        while(cnt!=pos-1){
            pre=pre.next;
            cnt++;
        }
        post=pre.next.next;
        pre.next=curnode;
        curnode.next=post;
        count++;



    }

    void replaceValue(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Scanner s=new Scanner(System.in);
        System.out.println("enter the value to be replaced:");
        int n=s.nextInt();
        System.out.println("enter the value:");
        int value=s.nextInt();
        node<Integer> temp=head;
        while(temp.data!=n){
            temp=temp.next;
        }
        temp.data=value;
    }

    void deleteAtBeginning(){
        if(head==null){
            return;
        }
        head=head.next;
        count--;
    }

    void deleteAtEnd(){
        if(head==null){
            return;
        }
        node<Integer> temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        count--;


    }

    void deleteAtPosition(){
        if(head==null){
            return;
        }
        Scanner s=new Scanner(System.in);
        System.out.println("enter the position");
        int pos=s.nextInt();
        node<Integer> temp=head;
        int cnt=0;
        while(cnt != pos-1){
            temp=temp.next;
            cnt++;
        }
        temp.next=temp.next.next;
        count--;

    }

    void deleteValue(){
        if(head==null){
            return;
        }
        Scanner s=new Scanner(System.in);
        System.out.println("enter the avlue");
        int value=s.nextInt();
        node<Integer> temp=head;
        if(head.data==value){
            head=head.next;
            return;
        }
        while(temp.next.data != value ){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        count--;
    }

     void search(){
         if(head==null){
            return;
        }
        Scanner s=new Scanner(System.in);
        System.out.println("enter the avlue");
        int value=s.nextInt();
        node<Integer> temp=head;
        int cnt=0;
        while(temp.next!=null){
            if(temp.data==value){
                System.out.println("the value exist in position:"+cnt);
                return;
            }
            temp=temp.next;
            cnt++;
        }
        System.out.println("value  does not exist...");


    }

    void count(){
        System.out.println("The no of elements in the list are:"+count);
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

}


class node<T>{
    T data;
    node<T> next;
    node(T data) {
        this.data=data;
    }
}