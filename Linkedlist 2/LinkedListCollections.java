import java.util.*;
public class LinkedListCollections {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.addFirst(0);
        list.addLast(5);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        list.remove();
        list.add(3, 300);
        System.out.println("\n"+list.size()+" "+list.contains(300));
        list.set(2, 200);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

    }
}
