import java.util.*;
public class selectionSort {
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
        so.selection(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
class Sort{
    public static void selection(int[] arr){
        for(int i=0;i<arr.length;i++){
            int index=i;
            for(int j=index;j<arr.length;j++){
                if(arr[j]<arr[index]){
                    index=j;
                }
            }
            int temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
        
    }
}