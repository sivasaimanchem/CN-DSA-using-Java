import java.util.*;
public class CalculatePower{

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
       // calculatePower cp=new calculatePower();
       System.out.println("Calculating power");
        int n=s.nextInt();
        int ans=fact(n);
        System.out.println(ans);
    }
    
}