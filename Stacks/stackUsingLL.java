import java.util.*;
public class stackUsingLL {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        LLStack LLS=new LLStack();
        boolean a=true;
        while(a){
            System.out.println("enter the option number of the requried operation:");
            int n=s.nextInt();
            switch (n){
                case 0:
                    LLS.push();
                    break;
                case 1:
                    LLS.pop();
                    break;
                case 2:
                    LLS.size();
                    break;
                case 3:
                    LLS.isEmpty();
                    break;
                case 4:
                    LLS.top();
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
class LLStack{
    int size;
    node head;
    LLStack() {
        size=0;
        head=null;
    }

    void push(){
        Scanner s=new Scanner(System.in);
        System.out.println("enter the value to be inserted");
        int value=s.nextInt();
        node newnode=new node(value);
        newnode.next = head;
        head=newnode;
        size++;

    }

    void pop(){
        if(head==null){
            System.out.println("stack underflow");
            return;
        }
        System.out.println(head.data+" was removed");
        head=head.next;
        size--;

    }

    void top(){
         if(head==null){
            System.out.println("stack underflow");
            return;
        }
        System.out.println(head.data);
    }

    void isEmpty(){
        if(head==null){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    void size(){
        System.out.println(size);
    }
    
}
class node{
    int data;
    node next;
    node(int data){
        this.data = data;
        next = null;
    }
}