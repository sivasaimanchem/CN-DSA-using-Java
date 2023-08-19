import java.util.*;
public class removeDuplicates {

    static ArrayList<Integer> removeduplicates(int[] arr){
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                result.add(arr[i]);
                map.put(arr[i], true);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for (int i=0; i<n; i++) {
            arr[i]=s.nextInt(); 
        }
        ArrayList<Integer> ans=removeduplicates(arr);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
