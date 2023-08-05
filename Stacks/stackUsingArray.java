import java.util.*;
public class stackUsingArray {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        operations op=new operations();
        boolean a=true;
        while(a){
            System.out.println("enter the option number of the requried operation:");
            int n=s.nextInt();
            switch (n){
                case 0:
                    op.push();
                    break;
                case 1:
                    op.pop();
                    break;
                case 2:
                    op.size();
                    break;
                case 3:
                    op.isEmpty();
                    break;
                case 4:
                    op.top();
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
    int index;
    int capacity;
    int arr[];
    operations(){
        index=-1;
        arr=new int[4];
        capacity=4;
    }
    void push(){
        Scanner s=new Scanner(System.in);
        if(arr.length==capacity){
            int[] arr2= new int[capacity*2];
            for(int i=0;i<arr.length;i++){
                arr2[i]=arr[i];
            }
            arr=arr2;
            capacity*=2;
        }
        index++;
        System.out.println("enter the value to be instred:");
        int value=s.nextInt();
        arr[index]=value;
        
    }
    void pop(){
        if(index<=0){
            System.out.println("stack underflow");
            return;
        }
        System.out.println("removed element is " + arr[index]);
        index--;
    }
    void size(){
        System.out.println(index+1);
    }
    void isEmpty(){
        if(index<0){
            System.out.println("true");
        }else{
             System.out.println("false");
             System.out.println(index);
        }
    }
    void top(){
        System.out.println(arr[index]);
    }
}
