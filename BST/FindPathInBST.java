import java.util.*;
public class FindPathInBST {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BST BST=new BST();
        System.out.println("enter the no of elements to be inserted:");
        int n=s.nextInt();
        for (int i=0; i<n; i++){
            BST.insert();
        }
        BST.display();
        ArrayList<Integer> a = BST.FindPath();
        for (int i=0; i<a.size(); i++) {
            System.out.print(a.get(i)+" ");
        }
    }
}
class BST{
    BSTNode root;
    int size;

    ArrayList<Integer> FindPath(){
        Scanner scanner = new Scanner(System.in);
        int value=scanner.nextInt();
        return FindPath(root,value);
    }

    ArrayList<Integer> FindPath(BSTNode root,int value) {
        if(root==null){
            return null;
        }
        if(root.data==value){
            ArrayList<Integer> result=new ArrayList<Integer>();
            result.add(root.data);
            return result;
        }
        else if(value<root.data){
            ArrayList<Integer> leftans=FindPath(root.left, value);
            if(leftans!=null){
                leftans.add(root.data);
            }
            return leftans;
        }
        else{
            ArrayList<Integer> rightans=FindPath(root.right, value);
            if(rightans!=null){
                rightans.add(root.data);
            }
            return rightans;
        }
    }

    void insert(){
        Scanner s=new Scanner(System.in);
        int value=s.nextInt();
        root=insert(root,value);
    }
    BSTNode insert(BSTNode root,int value){
        if(root==null){
            BSTNode newnode = new BSTNode(value);
            return newnode;
        }
        if(root.data<=value){
            root.right=insert(root.right, value);
        }else{
            root.left=insert(root.left, value);
        }
        return root;
    }

    void delete(){
        Scanner s=new Scanner(System.in);
        int value=s.nextInt();
        root=delete(root,value);
    }
    BSTNode delete(BSTNode root, int value) {
        if(root==null){
            return null;
        }
        if(root.data>value){
            root.left=delete(root.left, value);
            return root;
        }
        else if(root.data<value){
            root.right=delete(root.right, value);
            return root;
        }
        else{
            if(root.right==null && root.left==null){
                return null;
            }
            else if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                BSTNode node=root.right;
                while(node.left!=null){
                    node=node.left;
                }
                root.data=node.data;
                delete(root.right, node.data);
                return root;
            }
        }
        
    }
    void search(){
        if(root==null){
            return;
        }
        Scanner s=new Scanner(System.in);
        int value=s.nextInt();
        search(root,value);
        
    }
    void search(BSTNode root,int value){
        if(root.data==value){
            System.out.println("true");
            return;
        }
        if(root.data<=value){
            search(root.right, value);
        }else{
            search(root.left, value);
        }
    }
    void display(){
        display(root);
    }
    
    void display(BSTNode node){
        if(node==null){
            return;
        }
        System.out.println(node.data+":");
        if(node.left!=null){
            System.out.println("L:"+node.left.data);
        }
        if(node.right!=null){
            System.out.println("R:"+node.right.data);
        }
        display(node.left);
        display(node.right);
    }
}

class BSTNode{
    int data;
    BSTNode left;
    BSTNode right;
    BSTNode(int data){
        this.data = data;
    }

}