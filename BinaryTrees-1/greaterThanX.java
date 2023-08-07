import java.util.*;
public class greaterThanX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        System.out.println("enter the value to be compared");
        int n=s.nextInt();
        System.out.println(op.nodesGreaterThanX(node,n));
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
    int nodesGreaterThanX( BTNode<Integer> node,int value){
        if(node==null){
            return 0;
        }
        int count=0;
        if(value<node.data){
             count=1;
        }
        
        if(node.left!=null){
            count+= nodesGreaterThanX(node.left,value);
        }
        if(node.right!=null){
            count+=nodesGreaterThanX(node.right,value);
        }
        return count;
        
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