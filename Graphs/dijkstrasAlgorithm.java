import java.util.Scanner;

public class dijkstrasAlgorithm {
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
        dijkstra(matrix);
    }

    private static void dijkstra(int[][] matrix) {
        int n=matrix.length;
        boolean[] visited=new boolean[n];
        int[] distance=new int[n];
        distance[0]=0;
        for (int i=1; i<n; i++) {
            distance[i]=Integer.MAX_VALUE;
        }
        for (int i=1; i<n; i++){
            int minvertex=getMinVertex(visited,distance);
            visited[minvertex]=true;
            for(int j=0;j<n;j++) {
                if(matrix[minvertex][j]>0 && !visited[j] && matrix[minvertex][j] != Integer.MAX_VALUE) {
                    int dist=distance[minvertex]+matrix[minvertex][j];
                    if(dist<distance[j]){
                        distance[j] = dist;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(i+" "+distance[i]);
        }
    }

    private static int getMinVertex(boolean[] visited, int[] distance) {
        int minvertex=-1;
        for(int i=0; i<visited.length; i++) {
            if(!visited[i] && ( minvertex==-1 || distance[i] < distance[minvertex])){
                minvertex = i;
            }
        }
        return minvertex;
    }
}
