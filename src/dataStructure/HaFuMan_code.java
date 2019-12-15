package dataStructure;

import javax.swing.*;
import java.sql.Connection;
import java.util.*;

public class HaFuMan_code {
    public static <entry> void main(String[] args) {
        Map<String, String> tempMap = new HashMap<String, String>();
        tempMap.put("a","1");
        tempMap.put("b","2");
        tempMap.put("c","3");
        tempMap.put("d","4");

        HashSet<String> basicNodeSet = new HashSet<>();
        basicNodeSet.add("a");
        basicNodeSet.add("b");
        basicNodeSet.add("c");
        basicNodeSet.add("d");

        List<Node> nodes = new ArrayList<Node>();
        for(Map.Entry<String, String> entry: tempMap.entrySet()){
            Node node = new Node(Integer.parseInt(entry.getValue()));
            node.nameAndCode = entry;
            nodes.add(node);
        }

        Node root = creatHaFuManTree(nodes);
        System.out.println("root："+root);
        root.parent = null;

        preOrder(root);

        System.out.println("==========================输出哈夫曼编码结果=======================");
        HashMap<String, String> huffmanMap = new HashMap<>();
        printHFM(root, basicNodeSet, huffmanMap);
        Iterator<Map.Entry<String, String>> entries;

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("c");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("d");
        linkedList.add("d");
        linkedList.add("d");

        /*输出哈夫曼编码*/
        for (String s : linkedList)
        {
            entries = huffmanMap.entrySet().iterator();
            while (entries.hasNext() == true){
                Map.Entry<String,String> temp = entries.next();
                if(s.equals(temp.getKey())){
                    System.out.print(temp.getValue());
                }
            }
        }
        System.out.println();
        System.out.println(linkedList);

    }

    private static void printHFM(Node root, HashSet<String> basicNodeSet,HashMap<String, String> huffmanMap) {
        if (root != null){
            Node trap =  root;
            Map.Entry va = trap.nameAndCode;
            if(basicNodeSet.contains(va.getKey())){
                System.out.println(va.getKey() + ":" +va.getValue());
                huffmanMap.put(va.getKey().toString(),va.getValue().toString());
            }
            printHFM(trap.left, basicNodeSet,huffmanMap);
            printHFM(trap.right, basicNodeSet,huffmanMap);

        }
    }

    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("该树为空树，遍历失败");
        }
    }

    public static Node creatHaFuManTree(List<Node> nodes){
        System.out.println("++++++++++++++++++++++++++++++哈夫曼树构建之前，nodes="+nodes);

        //建立哈弗曼树
        int temp = 100;
        while (nodes.size() > 1){
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.w_value+right.w_value);

            Map<String, String> map = new HashMap<>();

            map.put(String.valueOf(temp),String.valueOf(temp++));
            Iterator iter = map.entrySet().iterator();
            if(iter.hasNext()){
                parent.nameAndCode = (Map.Entry<String, String>) iter.next();
            }
            parent.left = left;
            parent.right = right;
            left.parent = parent;
            right.parent = parent;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);

            System.out.println("哈夫曼树构建过程，nodes="+nodes);
        }
        System.out.println("++++++++++++++++++++++++++++++哈夫曼树构建之后，nodes="+nodes);
        return nodes.get(0);
    }
}

/*Huffman树节点结构*/
class Node implements Comparable<Node>{

    //用于编码的具体指
    Map.Entry<String, String > nameAndCode;
    int w_value; //权值
    Node left;
    Node right;
    Node parent;

    public Node(int value){
        this.w_value = value;
    }

    @Override
    public int compareTo(Node node){
        return this.w_value-node.w_value;//实现从小到大排序
//        return -(this.w_value-node.w_value); //实现从大到小排序
    }

    /*关键代码：
    * 实现具体编码*/
    public void preOrder(){
        /*父结点*/
        System.out.println("当前节点：" + this);
        if (this.parent == null){
            this.nameAndCode.setValue("");
        }else if(this.parent != null){
            if (this.parent.left == this){
                String code = (this.parent.nameAndCode.getValue() + 0);
                this.nameAndCode.setValue(code);
            }
            if (this.parent.right == this){
                String code = (this.parent.nameAndCode.getValue() + 1);
                this.nameAndCode.setValue(code);
            }
        }
        /*左子树*/
        if(this.left != null){
            this.left.preOrder();
        }
        /*右子树*/
        if (this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "nameAndCode=" + nameAndCode +
                ", w_value=" + w_value +
                '}';
    }
}