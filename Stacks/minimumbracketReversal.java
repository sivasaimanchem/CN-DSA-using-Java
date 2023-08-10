import java.util.*;
public class minimumbracketReversal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LLStack ll=new LLStack();
        System.out.println("enter the bracket sequence");
        String str=s.next();
        System.out.println(ll.mbr(str));

    }
}
class LLStack{
    int size;
    node head;
    LLStack() {
        size=0;
        head=null;
    }

    int mbr(String str){
        int len=str.length();
        if(len%2!=0){
            return -1;
        }
        for( int i=0;i<len;i++){
            char ch=str.charAt(i);
            if(ch=='{'){
                push(ch);
            }
            if(ch=='}'){
                if(isEmpty() ||top()=='}' ){
                    push(ch);
                }else{
                    pop();
                }
            }
        }
        int count=0;
        while(!isEmpty()){
            char ch1=pop();
            char ch2=pop();
            if(ch1==ch2){
                count++;
            }else{
                count+=2;
            }
        }
        return count;
    }

    void push(char value){
        node newnode=new node(value);
        newnode.next = head;
        head=newnode;
        size++;

    }

    char pop(){
        if(head==null){
            System.out.println("stack underflow");
        }
        char val=head.data;
        head=head.next;
        size--;
        return val;

    }

    char top(){
        if(head==null){
            System.out.println("stack underflow");
            return 0;
        }
        return head.data;
    }

    boolean isEmpty(){
        boolean bool;
        if(head==null){
            bool = true;
            //System.out.println("true");
        }else{
            bool = false;
            //System.out.println("false");
        }
        return bool;
    }

    void size(){
        System.out.println(size);
    }
    
}
class node{
    char data;
    node next;
    node(char data){
        this.data = data;
        next = null;
    }
}
