import java.util.*;

public class CreateAndInsertDuplicateNode {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        op.display(node);
        op.addDuplicate(node);
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
	void addDuplicate(BTNode<Integer> root) {
		if(root == null) {
			return;
		}
        BTNode<Integer> duplicate=new BTNode<Integer>(root.data);
        BTNode<Integer> temp=root.left;
        root.left=duplicate;
        duplicate.left=temp;
        addDuplicate(root.left.left);
        addDuplicate(root.right);

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