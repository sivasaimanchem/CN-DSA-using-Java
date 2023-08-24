import java.util.*;

public class kruskalsAlgorithm{
    public static void main(String[] args) {
        Scanner s=new Scanner( System.in );
        int v=s.nextInt();
        int e=s.nextInt();
        Edge edges[]=new Edge[e];
        for( int i=0; i<e; i++ ){
            int v1=s.nextInt();
            int v2=s.nextInt();
            int weight=s.nextInt();
            Edge edge=new Edge(v1,v2,weight);
            edges[i]=edge;
        }
        Edge mst[] = kruskals(edges, v);
        for(int i = 0; i < mst.length; i++)
        {
            if(mst[i].v1 < mst[i].v2)
            {
                System.out.println(mst[i].v1 +" "+mst[i].v2 +" " + mst[i].weight);
            }
            else
            {
                System.out.println(mst[i].v2 +" "+mst[i].v1 +"  " + mst[i].weight);
            }
        }



    }

    public static Edge[] kruskals(Edge[] edges, int v) {
        Arrays.sort(edges);
        Edge MST[]=new Edge[v-1];
        int parents[]=new int[v];
        for(int i=0;i<v;i++){
            parents[i] =i;
        }
        int count = 0,i=0;
        while(count!=v-1){
            Edge curr=edges[i++];
            int v1=getParent(curr.v1,parents);
            int v2=getParent(curr.v2,parents);
            if(v1!=v2){
                MST[count]=curr;
                count++;
                parents[v1]=v2;
            }
        }
        return MST;
    }

    private static int getParent(int v, int[] parents) {
        if(parents[v]==v){
            return v;
        }
        return getParent(parents[v], parents);
    }
}
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;
    Edge(int v1, int v2, int weight) {
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
    }
    public int compareTo(Edge other) {
        return this.weight-other.weight;
    }
}