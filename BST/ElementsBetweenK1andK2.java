import java.util.Scanner;

public class ElementsBetweenK1andK2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        BST BST=new BST();
        System.out.println("enter the no of elements to be entered: ");
        int n=s.nextInt();
        for (int i=0; i<n; i++) {
            BST.insert();
        }
        
        BST.k1andk2();
    }
}

class BST{
    BSTNode root;
    int size;
    void k1andk2() {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the k1 and k2 values: ");
        int k1=s.nextInt();
        int k2=s.nextInt();
        k1andk2(root, k1, k2);
    }
    void k1andk2(BSTNode root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data<k1){
            k1andk2(root.right, k1, k2);
        }
        else if(root.data>k2){
            k1andk2(root.right, k1, k2);
        }else{
            k1andk2(root.left, k1, k2);
            System.out.print(root.data+" ");
            k1andk2(root.right, k1, k2);
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