import java.util.*;
//needs to be corrected................................................................
public class getPathBFS {
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
        System.out.println("enter starting and ending vertex");
        int start=s.nextInt();
        int end=s.nextInt();
        ArrayList<Integer> ans=getPath(matrix, start, end);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }

    private static ArrayList<Integer> getPath(int[][] graph, int v1, int v2) {
        int V = graph.length;

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        HashMap<Integer, Integer> pathMap=new HashMap<Integer, Integer>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v1);
        visited[v1] = true;

        boolean pathFound = false;

        while (!queue.isEmpty()) {
            int currVertex = queue.poll();

            // If the destination vertex is found, break the loop
            if (currVertex == v2) {
                pathFound = true;
                break;
            }

            // Explore all the adjacent vertices of the current vertex
            for (int i = 0; i < V; i++) {
                if (graph[currVertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    parent[i] = currVertex;
                }
            }
        }

        // If a path is found, backtrack to get the shortest path
        ArrayList<Integer> path = new ArrayList<>();
        if (pathFound) {
            int currVertex = v2;
            while (currVertex != v1) {
                path.add(currVertex);
                currVertex = parent[currVertex];
            }
            path.add(v1);
        }

        return path;
    }
}
