import java.util.*;
public class binarySearch {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        Search se=new Search();
        System.out.println("enter array size:");
        int n=s.nextInt();
        int arr[]=new int[n];
        System.out.println("enter array elemenets ins sorted order:");
        for(int i=0;i<arr.length;i++){
            arr[i]=s.nextInt();
        }
        System.out.println("enter the element which has to be searched:");
        int ele=s.nextInt();
        System.out.println(se.binary(arr,ele));
    }
}
class Search{
    public static int binary(int[] arr,int ele){
        int low=0,mid,high=arr.length-1;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==ele){
                return mid;
            }
            else if(arr[mid]<ele){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}