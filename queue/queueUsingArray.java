import java.util.*;
public class queueUsingArray {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        operations op=new operations();
        boolean a=true;
        while(a){
            System.out.println("enter the option number of the requried operation:");
            int n=s.nextInt();
            switch (n){
                case 0:
                    op.enqueue();
                    break;
                case 1:
                    op.dequeue();
                    break;
                case 2:
                    op.size();
                    break;
                case 3:
                    op.isEmpty();
                    break;
                case 4:
                    op.front();
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
class operations{
    int size;
    int arr[];
    int front;
    int rear;
    operations(){
        arr=new int[2];
        front=0;
        rear=0;
    }
    void enqueue(){
        Scanner s=new Scanner(System.in);
        if(arr.length==size){
            doublesize();   
        }
        if(rear==arr.length){
                rear=0;
        }
        System.out.println("enter the value to be instred:");
        int value=s.nextInt();
        arr[rear]=value;
        rear++;
        size++;
        
    }
    void dequeue(){
        if(size==0){
            System.out.println("stack underflow");
            return;
        }
        if(front==arr.length){
                front=0;
        }
        System.out.println("removed element is " + arr[front]);
        front++;
        size--;
    }
    void size(){
        System.out.println(size);
    }
    void isEmpty(){
        if(size<=0){
            System.out.println("true");
        }else{
             System.out.println("false");
        }
    }
    void front(){
        System.out.println(arr[front]);
    }
    void doublesize(){
        int index=0;
        int arr2[]=new int[size*2];
        for(int i=front;i<arr.length;i++){
            arr2[index]=arr[i];
            index++;
        }
        for(int i=0;i<front;i++){
            arr2[index]=arr[i];
            index++;
        }
        arr=arr2;
        front=0;
        rear=size;
    }
}
