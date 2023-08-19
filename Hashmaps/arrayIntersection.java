import java.util.*;

public class arrayIntersection {

    static void printintersection(int arr1[], int arr2[]){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr1.length;i++) {
            if(map.containsKey(arr1[i])){
                map.put(arr1[i], map.get(arr1[i])+1);
            }else{
                map.put(arr1[i],1);
            }
        }

        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                int freq=map.get(arr2[i]);
                if(freq>0){
                    System.out.print(arr2[i]+" ");
                    map.put(arr2[i], map.get(arr2[i])-1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the no of elements in array 1:");
        int n1=s.nextInt();
        int arr1[]=new int[n1];
        for (int i=0; i<n1; i++) {
            arr1[i]=s.nextInt();
        }
        System.out.println("enter the number of elements in array 2:");
        int n2=s.nextInt();
        int arr2[]=new int[n2];
        for (int i=0; i<n2; i++) {
            arr2[i]=s.nextInt();
        }
        printintersection(arr1,arr2);
    }
}
