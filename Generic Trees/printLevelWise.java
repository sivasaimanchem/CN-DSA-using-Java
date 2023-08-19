import java.util.*;
public class  printLevelWise{
    public static void main(String[] args) {
        genericTrees<Integer> gt=new genericTrees<>();
        gt.constructTree();
        gt.displayTreeLevelWise();
        
    }
}

class genericTrees<T>{
    treeNode<Integer> root;
    void constructTree(){
        Scanner s=new Scanner(System.in);
        Queue<treeNode<Integer>> pendingNodes=new LinkedList<>();
        System.out.println("enter the root node data:");
        int value = s.nextInt();
        root = new treeNode<Integer>(value);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            treeNode<Integer> presentNode=pendingNodes.poll();
            System.out.print("enter the no.of children for " + presentNode.data+":");
            int child=s.nextInt();
            for(int i=0; i<child; i++){
                System.out.print("enter the "+i+" child value: ");
                int val=s.nextInt();
                treeNode<Integer> childNode=new treeNode<>(val);
                presentNode.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
    }
     
    void displayTreeLevelWise(){
        if(root==null) return;
        System.out.println("printing tree levelwise................................................................");
        Queue<treeNode<Integer>> waiting=new LinkedList<>();
        waiting.add(root);
        waiting.add(null);
        System.out.println(root.data);
        while(!waiting.isEmpty()){
            treeNode<Integer> presentNode = waiting.poll();
            if(presentNode==null){
                if(waiting.isEmpty()){
                    return;
                }else{
                    System.out.println();
                    waiting.add(null);
                }
            }else{
                for(int i=0; i<presentNode.children.size(); i++){
                    System.out.print(presentNode.children.get(i).data+" ");
                    waiting.add(presentNode.children.get(i));
                }
            }
        }

    }

}

class treeNode<T>{
    T data;
    ArrayList<treeNode<T>> children;
    treeNode(T data) {
        this.data = data;
        this.children = new ArrayList<treeNode<T>>();
    }
}