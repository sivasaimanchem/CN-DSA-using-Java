import java.util.*;

public class BFS {
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

    private static void dfsTraversal(int[][] matrix) {
        Queue<Integer> queue =new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        for(int startVertex=0;startVertex<matrix.length;startVertex++){
            if(visited[startVertex]==false){
                visited[startVertex] = true;
                queue.add(startVertex);
                System.out.println();
            }
            
            while(!queue.isEmpty()) {
                int temp=queue.poll();
                System.out.print(temp+" ");
                for(int i=0;i<matrix.length;i++) {
                    if(matrix[temp][i]==1 && !visited[i]==true){
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }
}
