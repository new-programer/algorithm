package algorithmsForJob;

import java.util.HashMap;
import java.util.Map;

public class reConstructBinaryTree {
    private Map<Integer, Integer> indexForInOrder = new HashMap<>();
    public static void main(String[] args) {


        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};

        TreeNode treeNode = reConstructBinaryTree(pre,in);
    }

    //Solution
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int l1, int r1, int[] in, int l2, int r2){
        if(l1 > r1){
            return null;
        }

        int i=l2;
        for(; i<r2; i++){
            if(pre[l1] == in[i])
                break;
        }
        TreeNode sNode = new TreeNode(in[i]);
        //construct left tree
        sNode.left = reConstructBinaryTree(pre, l1+1, l1+i-l2, in, l2, i-1);
        //construct right tree
        sNode.right = reConstructBinaryTree(pre, l1+i-l2+1, r1, in, i+1, r2);
        return sNode;
    }
}



class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

