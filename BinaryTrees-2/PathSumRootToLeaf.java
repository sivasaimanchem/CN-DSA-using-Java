import java.util.*;

public class PathSumRootToLeaf {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        op.findPath(node);
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
    void  findPath(BTNode<Integer> root){
       Scanner scanner= new Scanner(System.in);
       int k=scanner.nextInt();
       findpathHelper(root,k,"",0);
    }
    void findpathHelper(BTNode<Integer> root,int k,String path,int sum){
        if(root==null){
            return;
        }
        if(root.right==null && root.left==null){
            sum+=root.data;
            if(sum==k){
                System.out.println(path+root.data+" ");
                return;
            }
        }
        findpathHelper(root.left,k,path+root.data+" ",sum+root.data);
        findpathHelper(root.right,k,path+root.data+" ",sum+root.data);

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
