import java.util.*;
public class isBalanced{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        pair sol=new pair();
        sol=op.isBalanced(node);
        System.out.println(sol.isbalanced);
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
    void display(BTNode<Integer> node){
        if(node==null) return;
        System.out.println(node.data);
       if(node.left!=null){
         display(node.left);
       }
       if(node.right!=null){
         display(node.right);
       }
    }
    
    pair isBalanced(BTNode<Integer> root)
    {
        if (root==null)
        {
            pair pair=new pair();
            pair.isbalanced = true;
            pair.height=0;
            return pair;
        }
        pair ans=new pair();
        pair leftOutput=isBalanced(root.left);
        pair rightOutput=isBalanced(root.right);
        ans.isbalanced=true;
        ans.height=Math.max(leftOutput.height,rightOutput.height)+1;
        if(Math.abs(leftOutput.height-rightOutput.height)>1){
            ans.isbalanced=false;
        }
        if(!leftOutput.isbalanced || !rightOutput.isbalanced){
            ans.isbalanced=false;
        }
        return ans;
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
class pair{
    int height;
    boolean isbalanced;
    // pair(boolean isbalanced){
    //     this.isbalanced=isbalanced;
    // }

}