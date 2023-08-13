import java.util.*;
public class diameterOfTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        operations op=new operations();
        BTNode<Integer> node=op.takeInput(true,0,false);
        System.out.println(op.diameterOfBinaryTree(node));
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
    static int diameter;
	int getMaxDepth(BTNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftSubtreeDepth = getMaxDepth(root.left);
		int rightSubtreeDepth = getMaxDepth(root.right);
		diameter = Math.max(diameter, leftSubtreeDepth + rightSubtreeDepth);
		return Math.max(leftSubtreeDepth, rightSubtreeDepth) + 1;
	}
    public int diameterOfBinaryTree(BTNode<Integer> root) {
        diameter = 0;
		getMaxDepth(root);
		return diameter;
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