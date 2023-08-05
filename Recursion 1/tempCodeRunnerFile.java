package Recursion;
import java.util.*;
public class calculatePower{

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
       // calculatePower cp=new calculatePower();
        int n=s.nextInt();
        int ans=fact(n);
        System.out.println(ans);
    }
    
}