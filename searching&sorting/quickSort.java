import java.util.*;
public class quickSort {

    public static void sort(int arr[], int start, int end){
        if(start >=end){
             return;
        }
        int pivot=partition(arr, start, end);
        sort(arr, start,pivot-1 );
        sort(arr, pivot+1,end);
    }

    static int partition(int[] arr, int start, int end){
        int n=arr[start];
        int count=0;
        for(int i=start+1; i<=end; i++){
            if(arr[i]<n) count++;
        }
        int temp=arr[start+count];// important
        arr[start+count]=arr[start];
        arr[start]=temp;

        int i=start, j=end;
        while(i<j){
            if(arr[i]<=n){
                i++;
            }
            else if(arr[j]>n) {
                j--;
            }
            else{
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return start+count;
    }
    public static void main(String[] args){
         
        Scanner s=new Scanner(System.in);
        System.out.println("enter size of the array:");
        int n=s.nextInt();

        int arr[]=new int[n];
        System.out.println("enter the array elements:");
        for(int i=0;i<arr.length;i++) {
            arr[i]=s.nextInt();
        }

        System.out.println("array elements before sorting");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }

        sort(arr,0,arr.length-1);

        System.out.println("\narray elements after sorting");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
