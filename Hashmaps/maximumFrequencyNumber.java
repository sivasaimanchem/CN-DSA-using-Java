import java.util.*;

public class maximumFrequencyNumber {

    static int maxFreq(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        int max=0, index=-1;
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])>max){
                max=map.get(arr[i]);
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the array length:");
        int n=s.nextInt();
        int arr[]=new int[n];
        System.out.println("enter the array values...");
        for (int i=0; i<n; i++) {
            arr[i]=s.nextInt(); 
        }
        int ans=maxFreq(arr);
            System.out.print("The max frequency number is:"+arr[ans]);
    }
}
