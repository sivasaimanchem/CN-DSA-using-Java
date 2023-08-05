import java.util.*;
public class bubbleSort {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        Sort so=new Sort();
        System.out.println("enter array size:");
        int n=s.nextInt();
        int arr[]=new int[n];
        System.out.println("enter array elemenets:");
        for(int i=0;i<arr.length;i++){
            arr[i]=s.nextInt();
        }
        so.bubble(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
class Sort{
    public static void bubble(int[] arr){
        int temp=0;
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}