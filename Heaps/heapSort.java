import java.util.*;
public class heapSort {

    static void sort(int[] arr){
        if(arr.length<2){
            return;
        }
        int n=arr.length;
        for(int i=(n/2)-1; i>=0; i--){
            downHepify(arr,i,n);
        }

        for(int i=n-1; i>=0; i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            downHepify(arr, 0, i);
        }
    }
    private static void downHepify(int[] arr, int i, int n) {
        int parentIndex=i;
        int leftChildIndex=(2*parentIndex)+1;
        int rightChildIndex=(2*parentIndex)+2;

        while(leftChildIndex<n){
            int minIndex = parentIndex;
            if(arr[leftChildIndex]<arr[minIndex]){
                minIndex=leftChildIndex;
            }
            if(rightChildIndex<n && arr[rightChildIndex]<arr[minIndex]){
                minIndex=rightChildIndex;
            }
            if(parentIndex==minIndex){
                return;
            }

            int temp=arr[parentIndex];
            arr[parentIndex]=arr[minIndex];
            arr[minIndex]=temp;

            parentIndex=minIndex;
            leftChildIndex=(2*parentIndex)+1;
            rightChildIndex=(2*parentIndex)+2;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int n=s.nextInt();
        int arr[]=new int[n];
        System.out.println("enter the arrary elements: ");
        for (int i=0; i<n; i++) {
            arr[i]=s.nextInt();
        }
        sort(arr);
        System.out.println("elements after sorting");
        for (int i=0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
