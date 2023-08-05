import java.util.*;
public class validParanthasis {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        LLStack LLS=new LLStack(); 
        System.out.println("enter the paranthasis expression:");
        String exp=s.next();
        LLS.evaluate(exp);

    }
}
class LLStack{
    int size;
    node head;
    LLStack() {
        size=0;
        head=null;
    }

    void evaluate(String exp){
        for(int i=0; i<exp.length(); i++){
            if(exp.charAt(i)=='(' || exp.charAt(i)=='{' || exp.charAt(i)=='['){
                push(exp.charAt(i));
                size++;
            }
            else if (exp.charAt(i)==')' || exp.charAt(i)=='}' || exp.charAt(i)==']'){
                if(size==0){
                    System.out.println("stack is empty");
                    return;
                }
                if (exp.charAt(i) == ')') {
                        if (top() != '(') {
                            System.out.println("false");
                            return;
                        } else {
                            pop();
                        }
                    }
                    if (exp.charAt(i) == ']') {
                        if (top() != '[') {
                            System.out.println("false");
                            return;
                        } else {
                            pop();
                        }
                    }
                    if (exp.charAt(i) == '}') {
                        if (top() != '{') {
                            System.out.println("false");
                            return;
                        } else {
                            pop();
                        }
                    }
            }
        }
        if(exp.length()==0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        return;
    }

    void push(char value){
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
        head=head.next;
        size--;

    }

     char top(){
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
    char data;
    node next;
    node(char data){
        this.data = data;
        next = null;
    }
}