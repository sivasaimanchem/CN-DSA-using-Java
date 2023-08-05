import java.util.*;
public class linerSearch {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        Search se=new Search();
        System.out.println("enter array size");
        int n=s.nextInt();
        int arr[]=new int[n];
        System.out.println("enetr array elemenets");
        for(int i=0;i<arr.length;i++){
            arr[i]=s.nextInt();
        }
        System.out.println("enter the element which has to be searched");
        int ele=s.nextInt();
        int ans=se.liner(arr,ele);
        System.out.println(ans);
        
    }
}
class Search{
    public static int liner(int[] arr, int ele){
         for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                return i;
            }
        }
        return -1;
    }
}