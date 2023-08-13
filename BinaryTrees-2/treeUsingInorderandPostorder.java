import java.util.*;

public class treeUsingInorderandPostorder {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        operations op=new operations();
        System.out.println("enter the length of inorder:");
        int n1=s.nextInt();
        int[] inorder=new int[n1];
        System.out.println("enter the length of preorder:");
        int n2=s.nextInt();
        int[] postorder=new int[n2];
        System.out.println("enter the inorder:");
        for (int i=0; i<n1; i++){
            inorder[i]=s.nextInt();
        }
        System.out.println("enter the postorder:");
        for (int i=0; i<n2; i++){
            postorder[i]=s.nextInt();
        }
        BTNode<Integer> root=op.constructTree(inorder,postorder);
        op.display(root);

       
    }

}
class operations {

    BTNode<Integer> constructTree(int[] inorder, int[] postorder){
        BTNode<Integer> root=constructTreehelper(inorder, postorder,0,inorder.length-1,0,postorder.length-1);
        return root;
    }
    BTNode<Integer> constructTreehelper(int[] inorder, int[] postorder,int is,int ie,int ps,int pe){

        if(ps>pe){
            return null;
        }
        System.out.println("constructing treehelper");
        int rootdata=postorder[pe];
        BTNode<Integer> root=new BTNode<>(rootdata);

        int rootIndexInorder=-1;
        for(int i=is;i<=ie;i++){
            if(inorder[i]==rootdata){
                rootIndexInorder=i;
                break;
            }
        }

        int sili=is;
        int eili=rootIndexInorder-1;
        int siri=rootIndexInorder+1;
        int eiri=ie;

        int silp=ps;
        int eirp=pe-1;
        
        int leftsubtreelength=eili-sili+1;
        int eilp=silp+leftsubtreelength-1;
        int sirp=eilp+1;

        BTNode<Integer> left=constructTreehelper(inorder, postorder, sili, eili, silp, eilp);
        BTNode<Integer> right=constructTreehelper(inorder, postorder, siri, eiri, sirp, eirp);

        root.right = right;
        root.left = left;

        return root;
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