package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        String fileName = "arr.txt";
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);

        int[][] array = new int[3][4];
        array[0][3] = 1;
        array[2][2] = 4;

        for(int[] arr : array){
            fileWriter.write(Arrays.toString(arr));
        }

        fileWriter.flush();
        fileWriter.close();
    }
}
