package dataStructure;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        String scVals = sc.nextLine();
        char[] vals = scVals.split(" ").toString().replace("[","")
                .replace("]","").toCharArray();
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < vals.length; i++) {
            values.add((int) vals[i]);
        }*/
        ArrayList<Integer> values = new ArrayList<>();

        {
            values.add(23);
            values.add(44);
            values.add(33);
            values.add(13);
            values.add(53);
            values.add(83);
            values.add(3);
            values.add(39);
        }
        //construct a binary tree

        TreeNode boot = new TreeNode(0);
        createBinaryTree(boot, values);

        //traverse a binary tree(width first)
        System.out.println("width first：");
        traverseBinaryTree_W(boot);

        //traverse a binary tree(depth first)
        System.out.println("depth first：");
        traverseBinaryTree_D(boot);
    }

    //1深度遍历二叉树（递归实现）
    private static void traverseBinaryTree_D(TreeNode boot) {
        if(boot != null){
            System.out.println(boot.val);
            traverseBinaryTree_D(boot.leftNode);
            traverseBinaryTree_D(boot.rightNode);
        }
    }

    //2广度遍历二叉树（需要借用队列）
    private static void traverseBinaryTree_W(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            /*just like "visit(boot)" operation*/
            root = queue.poll();
            System.out.println(root.val);

            //if the leftNode and the leftNode of boot exist, execute a "into queue" operation
            if (root.leftNode != null){
                queue.offer(root.leftNode);
            }
            if (root.rightNode != null){
                queue.offer(root.rightNode);
            }
        }
    }

    //create a binary tree
    public static void  createBinaryTree(TreeNode boot, ArrayList<Integer> values){
        Iterator<Integer> iter = values.iterator();
        boot.val = values.size() > 0? iter.next():-1; //如果迭代器中有元素，则将第一个元素的值赋给该节点，
        // 若无则赋值为-1(根结点的值为-1说明该树为空树)
        while(iter.hasNext()){
            insertBinaryTree(boot, iter.next());
        }

    }

    //insert a new TreeNode
    private static void insertBinaryTree(TreeNode boot, Integer value) {
        if(boot.val >= value){
            if(boot.leftNode == null){
                boot.leftNode = new TreeNode(value);
            }else{
                insertBinaryTree(boot.leftNode, value);
            }
        }else {
            if(boot.rightNode == null){
                boot.rightNode = new TreeNode(value);
            }else{
                insertBinaryTree(boot.rightNode, value);
            }
        }
    }
}

class TreeNode{
    protected int val;
    TreeNode leftNode, rightNode;
    TreeNode(int val){
        this.val = val;
    }
}