import java.util.*;
public class reverseStack {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        LLStack LLS=new LLStack(); 
        System.out.println("enter the no of elements to  be entered:");
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("enter the value to be inserted");
            int value=s.nextInt();
            LLS.push(value);
        }
        LLS.reverse();
        for(int i=0; i<n; i++){
            LLS.pop();
        }
    }
}
class LLStack{
    int size;
    node head;
    node newhead;
    LLStack() {
        size=0;
        head=null;
        newhead=null;
    }

    void reverse(){
        if(head==null || head.next==null){
            return;
        }
        node newstack;
        while(head!=null){
            System.out.println("hello");
            int num=pop();
            newstack=new node(num);
            newstack.next=newhead;
            head=head.next;
        }
        head=newhead;
    }

    void push(int value){
        node newnode=new node(value);
        newnode.next = head;
        head=newnode;
        size++;

    }

    int pop(){
        if(head==null){
            System.out.println("stack underflow");
            return -1;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;

    }

        int top(){
        if(head==null){
            System.out.println("stack underflow");
            return 0;
        }
        return head.data;
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