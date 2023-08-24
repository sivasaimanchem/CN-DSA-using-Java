import java.util.*;

public class primsAlgorithm {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int e=s.nextInt();
        int matrix[][]=new int[n][n];
        for(int i=0; i<e; i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            int weight=s.nextInt();
            matrix[v1][v2]=weight;
            matrix[v2][v1]=weight;
        }
        prims(matrix);
    }

    public static void prims(int[][] matrix){
        int length=matrix.length;
        boolean[] visited=new boolean[length];
        int[] parents=new int[length];
        int[] weights=new int[length];
        parents[0]=-1;
        weights[0]=0;
        for (int i=1; i<length; i++){
            weights[i]=Integer.MAX_VALUE;
        }
        for (int i=1; i<length; i++){
            int minvertex=getMinVertex(weights,visited);
            visited[minvertex]=true;
            for (int j=0; j<length; j++){
                if(matrix[minvertex][j]!=0 && !visited[j]){
                    if(matrix[minvertex][j]<weights[j]){
                        weights[j]=matrix[minvertex][j];
                        parents[j]=minvertex;
                    }
                }
            }
        }
        // as 0 is the source we start it from 1
        for(int i=1;i<length;i++){
            if(i<parents[i]){
                System.out.println(i+" "+parents[i]+" "+weights[i]);
            }else{
                System.out.println(parents[i]+" "+i+" "+weights[i]);
            }
        }

    }

    private static int getMinVertex(int[] weights, boolean[] visited) {
        int minvertex=-1;
        for(int i=0; i<weights.length; i++) {
            if(!visited[i] && (minvertex==-1 || weights[i]<weights[minvertex])){
                minvertex = i;
            }
        }
        return minvertex;
    }
}
