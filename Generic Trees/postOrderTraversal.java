import java.util.*;
public class postOrderTraversal {
    public static void main(String[] args) {
        genericTrees<Integer> gt=new genericTrees<>();
        gt.constructTree();
        gt.displayTree();
        gt.postorder();
    }
}

class genericTrees<T>{
    treeNode<Integer> root;

    void postorder(){
        postorderHelper(root);
    }
    void postorderHelper(treeNode<Integer> root){
        if(root==null){
            System.out.println("tree is empty");
            return;
        }
        for(int i=0;i<root.children.size();i++){
            postorderHelper(root.children.get(i));
        }
        System.out.print(root.data+" ");
    }

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

    void displayTree(){
        displayTreehelper(root);
    }

    void displayTreehelper(treeNode<Integer> root){
        if(root==null){
            System.out.println("tree is empty");
            return;
        }
        System.out.print(root.data+": ");
        for(int i=0; i<root.children.size(); i++){
            System.out.print(root.children.get(i).data+" ");
        }
        System.out.println();
        for(int i=0; i<root.children.size();i++) {
            treeNode<Integer> child = root.children.get(i);
            displayTreehelper(child);
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