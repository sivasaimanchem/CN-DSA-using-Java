import java.util.*;
public class BSTClass {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        BST BST=new BST();
        boolean a=true;
        while(a){
            System.out.println("enter the option number of the requried operation:");
            int n=s.nextInt();
            switch (n){
                case 0:
                    BST.insert();
                    break;
                case 1:
                    BST.delete();
                    break;
                case 2:
                    BST.search();
                    break;
                case 3:
                    BST.display();
                    break;
                case 5:
                    a=false;
                    break;
                default:
                    System.out.println("choose valid option");
            }
        }
    }
}

class BST{
    BSTNode root;
    int size;
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