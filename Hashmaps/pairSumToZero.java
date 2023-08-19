import java.util.*;

public class pairSumToZero {

    static int printpairs(int arr[]){
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        int pairs=0;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(-arr[i])&& map.get(arr[i])!=0){
                int times=0;
                if(arr[i]==(-arr[i])){
                    int occ=map.get(arr[i]);
                    times=((occ*(occ-1))/2);
                    pairs+=times;
                    map.put(arr[i],0);
                }else{
                    times=map.get(arr[i])*map.get(-arr[i]);
                    pairs+=times;
                    map.put(arr[i],0);
                    map.put(-arr[i],0);
                }
            }
        }
        return pairs;

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
         int arr[]=new int[n];
        for (int i=0; i<n; i++) {
            arr[i]=s.nextInt();
        }
        System.out.println(printpairs(arr));
    }
}
