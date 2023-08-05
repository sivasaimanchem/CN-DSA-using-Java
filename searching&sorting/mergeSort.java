import java.util.Scanner;

public class mergeSort {

    public static void merge(int[] arr, int l,int m,int h){
        int l1=m-l+1;
        int l2=h-m;

        int[] a1=new int[l1];
        int[] a2=new int[l2];

        for(int i=0;i<a1.length;i++){
            a1[i] =arr[l+i];
        }
        for(int i=0;i<a2.length;i++){
            a2[i] =arr[m+i+1];
        }
        int i=0,j=0;
        int k=l;
        while(i<a1.length && j<a2.length){
            if(a1[i]<=a2[j]){
                arr[k]=a1[i];
                i++;
                k++;
            }
            else{
                arr[k]=a2[j];
                j++;
                k++;
            }
        }
        while(i<a1.length ){
            arr[k]=a1[i];
            i++;
            k++;
        }
        while(j<a2.length ){
            arr[k]=a2[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] arr,int l,int h){
        if(l<h){
            int m= l+(h-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,h);
            merge(arr,l,m,h);
        }
        
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
