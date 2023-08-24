import java.util.Scanner;

public class isConnected {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int e=s.nextInt();
        int[][] matrix=new int[n][n];
        for (int i=0; i<e; i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            matrix[v1][v2]=1;
            matrix[v2][v1]=1;
        }
        Traversal(matrix);
    }

    static void Traversal(int[][] matrix){
        boolean[] check = new boolean[matrix.length];
        TraversalHelper(check,matrix,0);
        for(boolean i:check){
            if(i==false){
                System.out.print("not connected");
                return;
            }
        }
        System.out.println("connected");

    }
    private static void TraversalHelper(boolean[] check, int[][] matrix,int curr) {
        check[curr]=true;
        for(int i=0;i<check.length;i++){
            if(matrix[curr][i]==1 && check[i]==false){
                TraversalHelper(check, matrix, i);
            }
        }
    }
}
