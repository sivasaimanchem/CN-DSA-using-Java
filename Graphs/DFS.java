import java.util.*;
public class DFS {

    static void dfsTraversal(int[][] matrix){
        boolean[] check = new boolean[matrix.length];
        for(int i=0; i<matrix.length; i++){
            if(check[i]==false){
                dfsTraversalHelper(check,matrix,i);
                System.out.println();
            }
        }
    }
    private static void dfsTraversalHelper(boolean[] check, int[][] matrix,int curr) {
        check[curr]=true;
        System.out.print(curr+" ");

        for(int i=0;i<check.length;i++){
            if(matrix[curr][i]==1 && check[i]==false){
                dfsTraversalHelper(check, matrix, i);
            }
        }
    }
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
        dfsTraversal(matrix);
    }
}
