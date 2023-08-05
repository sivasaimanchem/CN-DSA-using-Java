1import java.util.Scanner;
public class isArraySorted {
    public static boolean isArray(int[] array, int size){
        if(size<=1){
            return true;
        }
        if(array[size]<array[size-1]){
            return false;
        }
        return isArray(array, size-1);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] array=new int[5];

        for(int i=0;i<array.length;i++){
            array[i]=scanner.nextInt();
        }
        if(isArray(array, array.length-1)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}
