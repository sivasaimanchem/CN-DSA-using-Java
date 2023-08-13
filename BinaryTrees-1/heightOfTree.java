import java.util.*;
public class heightOfTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        System.out.println(op.findHeight(node));
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
    int findHeight(BTNode<Integer> root){
         if (root==null)
        {
            return 0;
        }
        return findHeight(root.left)+findHeight(root.right)+1;
	}
    
    public static int findHeighthelper(BTNode<Integer> root)
    {
        if (root==null)
        {
            return 0;
        }
        int leftHeight=findHeighthelper(root.left);
        int rightHeight=findHeighthelper(root.right);
        
        return Math.max(leftHeight,rightHeight)+1;
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