import java.util.*;
public class checkBST {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        System.out.println(op.BSTcheck(node));
        //op.display(node);
    }
}
class operations {
    BTNode<Integer> takeInput(boolean isroot,int node,boolean isleft){

        if(isroot){
            System.out.println("enter root data ");
        }else if(isleft){
            System.out.println("enter left data of "+node);
        }else{
            System.out.println("enter right data of "+node);
        }
        Scanner s=new Scanner(System.in);
        int rootdata=s.nextInt();
        if(rootdata==-1){
            return null;
        }
        BTNode<Integer> newnode=new BTNode<>(rootdata);
        BTNode<Integer> rootleft= takeInput(false, rootdata, true);
        BTNode<Integer> rootright= takeInput(false, rootdata, false);
        newnode.left = rootleft;
        newnode.right = rootright;
        return newnode;
    }
    void  display(BTNode<Integer> node){
        if(node==null) return;
        System.out.println(node.data);
       if(node.left!=null){
         display(node.left);
       }
       if(node.right!=null){
         display(node.right);
       }
    }
    
    boolean BSTcheck(BTNode<Integer> node) {
        return BSTcheck(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean BSTcheck(BTNode<Integer> root, int minvalue, int maxvalue) {
        if (root == null) {
            return true;
        }
        if (root.data < minvalue || root.data > maxvalue) {
            return false;
        }
        boolean leftresult = BSTcheck(root.left, minvalue, root.data - 1);
        boolean rightresult = BSTcheck(root.right, root.data , maxvalue); 

        return leftresult && rightresult;
    }

}
class BTNode<T>{
    T data;
    BTNode<T> right;
    BTNode<T> left;
    BTNode(T data){
        this.data=data;
    }
}