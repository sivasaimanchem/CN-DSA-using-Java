import java.util.*;

public class getPathDFS{
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
        getpath(matrix, start, end);
    }

    static void getpath(int[][] matrix, int start, int end) {
        boolean[] visited=new boolean[matrix.length];
        ArrayList<Integer> ans=getPathHelper(matrix, start, end, visited);
        if(ans!=null){
            for(int i:ans){
                System.out.print(i+" ");
            }
        }else{
            System.out.println("path does not exist");
        }
    }
    static ArrayList<Integer> getPathHelper(int[][] matrix, int start, int end, boolean[] visited){
        if(start==end){
            visited[start]=true;
            ArrayList<Integer> path = new ArrayList<Integer>();
            path.add(start);
            return path;
        }
        visited[start]=true;
        for(int i=0;i<matrix.length;i++){
            if(matrix[start][i]==1 && visited[i]==false){
                ArrayList<Integer> path = getPathHelper(matrix, i, end, visited);
                if(path!=null){
                    path.add(start);
                    return path;

                }
            }
        }
        return null;

    }
}
