import java.util.*;
public class LastIndexOfNumber {
    public static int findNumber(int[] arr, int start, int value) {
        if (start < 0) {
            return -1;
        }
        
        if (arr[start] == value) {
            return start;
        }
        return findNumber(arr, start -1, value);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("Enter a value:");
        int a = s.nextInt();
        System.out.println(findNumber(arr, arr.length-1, a));
    }
}
