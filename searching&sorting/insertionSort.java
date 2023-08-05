import java.util.*;
public class insertionSort {
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
        so.insertion(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
class Sort{
    public static void insertion(int[] arr){
        for(int i=1;i<arr.length;i++){
            int index=i;
            int key=arr[index];
            int j=i-1;
            while(j>=0 && arr[j]>=key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}