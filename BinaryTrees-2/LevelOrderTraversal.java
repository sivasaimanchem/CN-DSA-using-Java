import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        op.display(node);
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
    void  display(BTNode<Integer> root){
       if(root==null){
			return;
		}
		Queue<BTNode<Integer>> queue= new LinkedList<BTNode<Integer>>();
		queue.add(root);
        queue.add(null);
		while(! queue.isEmpty()){
            BTNode<Integer> temp=queue.poll();
            if(temp==null){
                if(queue.isEmpty()){
                    return;
                }
                else{
                    System.out.println();
                    queue.add(null);
                }
            }
            else{
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }

            }
        }
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
