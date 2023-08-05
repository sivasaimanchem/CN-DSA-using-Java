
public class NoOfDigits {
    public static int countNo(int value){
        if(value==0){
            return 0;
        }
        return 1+countNo(value/10);
    }
    public static void main(String[] args){
        int num=3288828;
        int ans=countNo(num);
        System.out.println(ans);
    }
}
