import java.util.*;
public class replaceWithHeight {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        op.treeheight(node,0);
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
		while(! queue.isEmpty()){
			BTNode<Integer> front= queue.poll();
			if(front.left==null){
				System.out.print(front.data+":"+"L:"+"-1");
			}
			else{
				System.out.print(front.data+":"+"L:"+front.left.data);
				queue.add(front.left);
			}
			if(front.right==null){
				System.out.println(",R:"+"-1");
			}
			else{
				System.out.println(",R:"+front.right.data);
			    queue.add(front.right);
			}
		    
		}
    }
    void treeheight(BTNode<Integer> node,int value){
        if(node==null){
            return;
        }
        node.data=value;
        treeheight(node.left,value+1);
        treeheight(node.right,value+1);
        return;
        
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