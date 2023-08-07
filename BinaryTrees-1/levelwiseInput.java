import java.util.*;

public class levelwiseInput {
    public static void main(String[] args) {
        operations op=new operations();
        BTNode<Integer> node=op.takeInput();
        op.display(node);
    }
}

class operations{
    BTNode<Integer> takeInput(){
        Queue<BTNode<Integer>> list=new LinkedList<>();
        Scanner s=new Scanner(System.in);
        System.out.println("enter root data:");
        int value=s.nextInt();
        BTNode<Integer> newnode=new BTNode<>(value);
        list.add(newnode);
        while(!list.isEmpty()){
            BTNode<Integer> curr=list.poll();
            System.out.println("enter left node data of: " + curr.data);
            int val1=s.nextInt();
            if(val1!=-1){
                BTNode<Integer> leftnode=new BTNode<>(val1);
                curr.left = leftnode;
                list.add(leftnode);

            }
            
            System.out.println("enter right node data of: " + curr.data);
            int val2=s.nextInt();
            if(val2!=-1){
                BTNode<Integer> rightnode=new BTNode<>(val2);
                curr.right=rightnode;
                list.add(rightnode);
            }
        }
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
}

class BTNode<T>{
    T data;
    BTNode<T> right;
    BTNode<T> left;
    BTNode(T data){
        this.data=data;
    }
}
