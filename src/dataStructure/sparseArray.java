package dataStructure;

import java.util.Scanner;

/**
 * @Description 进行二维矩阵和稀疏矩阵的相互转换
 * @Author EricGao
 * @Date 8:01 2019/12/20
 */
public class sparseArray {
    public static void main(String[] args) {
        int[][] inArray = new int[7][8];
        inArray[2][3] = 3;
        inArray[1][5] = 2;

        for (int[] row : inArray){
            for (int data : row){
                System.out.print(data+ "\t");
            }
            System.out.println();
        }
        //get sparse Array
        int[][] sparseArr = toSparseArr(inArray);
        //get originalArray
        int[][] original = toOriginalArray(sparseArr);
    }
    public static int[][] getInArray(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[][] inArray = new int[7][8];

        for (int i = 0; i < inArray.length; i++) {
            for (int j = 0; j < inArray[i].length; j++) {
                inArray[i][j] = scanner.nextInt();
                System.out.println("\t" + inArray[i][j]);
            }
            System.out.println();
        }
        return inArray;
    }

    public static int[][] toSparseArr(int[][] inArray){
        //get the available value of Array "inArray";
        int rows = inArray.length,cols=inArray[0].length;
        int valueNum = 0;
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (inArray[i][j] != 0){
                    valueNum++;
                }
            }
        }
        System.out.println("the available value numbers:  " + valueNum);
        //create a sparse Array to store the available value of inArray
        int[][] sparseArr = new int[valueNum + 1][3];
        sparseArr[0][0] = rows;
        sparseArr[0][1] = cols;
        sparseArr[0][2] = valueNum;

        int count = 1; //the available value's SN(serial number)
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols; j++) {
                if (inArray[i][j] != 0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = inArray[i][j];
                    count++;//don't forget it
                }
            }
        }
        //test the result
/*
        System.out.println("==============the sparse array===============");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
*/
        System.out.println("==============the sparse array===============");
        for (int[] row : sparseArr){
            for (int data : row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        return sparseArr;
    }

    public static int[][] toOriginalArray(int[][] sparseArray){
        int rows=sparseArray[0][0], cols = sparseArray[0][1];
        int[][] orrignalArray = new int[rows][cols];

        //key code
        for (int i =1; i < sparseArray.length; i++) {
            orrignalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //test method function
        System.out.println("==============turn to original array===============");
        for (int[] row : orrignalArray){
            for (int data : row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        return orrignalArray;
    }
}
