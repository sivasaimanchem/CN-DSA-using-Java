import java.util.*;

public class stockSpan {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LLStack ll=new LLStack();
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0; i<n; i++) {
            arr[i]=s.nextInt();
        }
        int[] ans=ll.stocks(arr);
        for (int i=0; i<n; i++) {
            System.out.print(ans[i]+" ");
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

    int[] stocks(int[] arr){
        int len=arr.length;
        if(len==0 || len==1) return null;
        int[] ans=new int[len];
        LLStack stack=new LLStack();
        push(0);
        ans[0]=1;
        for(int i=1;i<len;i++){
            while(!isEmpty() && arr[i]>arr[top()]){
                pop();
            }
            if(isEmpty()){
                ans[i]= i+1;
            }else{
                ans[i]= i-top();
            }
            push(i);
        }
        return ans;
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
    int data;
    node next;
    node(int data){
        this.data = data;
        next = null;
    }
}