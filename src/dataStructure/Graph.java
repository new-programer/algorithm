package dataStructure;

import java.util.*;

public class Graph{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入图的类型表示，顶点数和边数，用空格隔开");
        GraphMatrix GM = new GraphMatrix(sc.nextInt(), sc.nextInt(), sc.nextInt());

        clearGraph(GM);
        if(Graph.createGraph(GM)){
            System.out.println("图创建成功");
        }
        //图的输出和遍历
        Graph.outGraph(GM);
//        Graph.deepTravGraph(GM);//dfs
        Graph.bfsTravGraph(GM);//bfs
/*      广度优先遍历，的结果如下，先遍历，A以及和A相连的顶点B D,后遍历B以及与B相连的顶点C(A本身已遍历过，此处不再遍历)
        A	B	C	D
        A	Z	3	Z	1
        B	3	Z	2	Z
        C	Z	2	Z	1
        D	1	Z	1	Z
        当前遍历顶点(广度优先遍历while前)：A
        当前遍历顶点(广度优先遍历while)：B
        当前遍历顶点(广度优先遍历while)：D
        当前遍历顶点(广度优先遍历while)：C
                */
        sc.close();
    }

    //创建图
    static boolean createGraph(GraphMatrix GM){
        int i,j = 0,k;
        char EstartV,EendV; //边起止顶点
        int weigth;
        Scanner input = new Scanner(System.in);
        System.out.println("输入图中各顶点信息：");
        for (i = 0; i < GM.VertexNum; i++) {
            System.out.println("第 "+(i+1) +" 个顶点：");
            GM.Vertex[i] = input.next().charAt(0);
        }

        System.out.println("输入构成各边的顶点及权值：");
        for (k = 0; k < GM.EdgeNum; k++) {
            System.out.println("第 "+(k+1) +" 条边：");
            EstartV = input.next().charAt(0);
            EendV = input.next().charAt(0);
            weigth = input.nextInt();

            for (i = 0; EstartV != GM.Vertex[i];i++);
            for (j = 0; EendV != GM.Vertex[j];j++);

            GM.EdgeWeight[i][j] = weigth;
            if(GM.GType == 0){
                GM.EdgeWeight[j][i] = weigth;
            }
        }
        input.close();
        return true;
    }

    //清空图
    static boolean clearGraph(GraphMatrix GM){
        for (int i = 0; i < GM.VertexNum; i++) {
            for (int j = 0; j < GM.VertexNum; j++) {
                GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;
            }
        }
        return true;
    }

    //显示图，即显示邻接矩阵,\t为制表符
    static void outGraph(GraphMatrix GM){
        System.out.println("图的邻接表如下：");
        for (int i = 0; i < GM.VertexNum; i++) {
            System.out.printf("\t%c",GM.Vertex[i]);
        }
        System.out.println();//换行
        for (int i = 0; i < GM.VertexNum; i++) {
            System.out.printf("%c",GM.Vertex[i]);
            for (int j = 0; j < GM.VertexNum; j++) {
                if (GM.EdgeWeight[i][j] == GraphMatrix.MaxValue){
                    System.out.printf("\tZ");
                }else{
                    System.out.printf("\t%d",GM.EdgeWeight[i][j]);
                }
            }
            System.out.println();//换行
        }
    }

    //遍历图
    //1.从任意一个顶点开始遍历深度遍历
    static void deepTravOne(GraphMatrix GM, int n){
        GM.isTrav[n] = 1;//首先遍历指定的顶点
        System.out.println("当前遍历顶点为："+GM.Vertex[n]);
        for (int i = n+1; i < GM.VertexNum; i++) {
            System.out.println("判断结果:"+(GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue && GM.isTrav[i]==0));
            if (GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue && GM.isTrav[i]==0)
            {
                deepTravOne(GM, i);
            }

        }
    }
    //2.深度优先遍历
    static void deepTravGraph(GraphMatrix GM){
        for (int i = 0; i < GM.VertexNum; i++) {
            GM.isTrav[i] = 0; //清除各定点遍历标志
        }
        System.out.println("深度优先遍历各个顶点：");
        for (int i = 0; i < GM.VertexNum; i++) {
            if (GM.isTrav[i] == 0){
                // 若是连通图，只会执行一次
                System.out.println("夜空中最亮的星");
                deepTravOne(GM, i);
            }
        }
        System.out.println();
    }

    //3.广度优先遍历
    static void bfsTravGraph(GraphMatrix GM){
        for (int i = 0; i < GM.VertexNum; i++) {
            GM.isTrav[i] = 0;//初始化遍历标志
        }
        //此处需要具体化存放的数据类型
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < GM.VertexNum; i++) {
            if (GM.isTrav[i] == 0){
                GM.isTrav[i] = 1; //标识当前顶点已被遍历
                System.out.println("当前遍历顶点(广度优先遍历while前)："+GM.Vertex[i]);
                queue.offer(i); //先遍历以i下标为顶点相连的各个元素，
            }
            while(!queue.isEmpty()){
                int index = queue.poll().intValue();
                for (int j = 0; j < GM.VertexNum; j++) {
                    if (GM.EdgeWeight[index][j] != GraphMatrix.MaxValue && GM.isTrav[j]==0){
                        GM.isTrav[j] = 1;
                        System.out.println("当前遍历顶点(广度优先遍历while)："+GM.Vertex[j]);
                        queue.offer(j);//后遍历以j下标为顶点相连的各个元素，
                    }
                }
            }
        }
        }
}

class GraphMatrix{
    static final int MaxNum = 20; //图最大顶点数
    static final int MaxValue = 65535; //最大值

    int GType; //图类型，0无向图，1有向图
    int VertexNum;
    int EdgeNum;

    char[] Vertex = new char[MaxNum];
    int[][] EdgeWeight = new int[MaxNum][MaxNum];
    int[] isTrav = new int[MaxNum]; //顶点遍历状态数组

    GraphMatrix(int gType, int vertexNum, int edgeNum)
    {
        this.GType = gType;
        this.VertexNum = vertexNum;
        this.EdgeNum = edgeNum;

        for (int i = 0; i < VertexNum; i++) {
            for (int j = 0; j < VertexNum; j++) {
                EdgeWeight[i][j] = MaxValue;
            }
        }
    }
}