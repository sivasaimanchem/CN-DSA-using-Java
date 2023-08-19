import java.util.*;

public class hashmapsInCollections {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("abc", 1);
        map.put("def", 2);
        if(map.containsKey("abc")) {
            System.out.println("map contains abc");
        }

        if(map.containsKey("abc1")) {
            System.out.println("map contains abc1");
        }

        int n=map.get("abc");
        System.out.println(n);

        if(map.containsKey("abc1")){
            int n2=map.get("abc1");
            System.out.println(n2);
        }else{
            System.out.println("abc1 does not exist");
        }

        map.remove("abc1");   // doesn't give any error unlike containsKey function

        map.put("ghi", 3);
        map.remove("ghi");
        System.out.println(map.containsKey("ghi"));
        System.out.println(map.size());
        System.out.println(map.get("abc"));
        map.put("abc",10);
        System.out.println(map.get("abc"));
        System.out.println(map.size()); 

        Set<String> keys = map.keySet();
        for( String s:keys ){
            System.out.print(s+" ");
        }
        System.out.println(map.containsValue(10));
    }
}
