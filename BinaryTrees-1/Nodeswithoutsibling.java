import java.util.*;
public class Nodeswithoutsibling {
    public static void main(String[] args) {
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        op.nosibling(node);
        op.display(node);

    }
}
class operations{

    void nosibling(BTNode<Integer> root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        if(root.right==null){
            System.out.println(root.left.data+" ");
            nosibling(root.left);
        }
        else if(root.left==null){
            System.out.println(root.right.data+" ");
            nosibling(root.right);
        }else{
            nosibling(root.left);
            nosibling(root.right);
        }
    }

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
        System.out.print(+node.data+":");
        if(node.left!=null){
            System.out.print("L:"+node.left.data);
        }
        if(node.right!=null){
            System.out.print("  R:"+node.right.data);
        }
        System.out.println();
        
        display(node.left);
        display(node.right);
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