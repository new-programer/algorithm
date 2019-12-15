package dataStructure.HuffmanCode;

import java.util.Arrays;

public class DataCompression {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("code");
        StringBuilder sbs = new StringBuilder(sb);

        sbs.append("_huffman");

        System.out.println(sbs);

        byte[] bytes = "abfsdfw".getBytes();
        System.out.println("bytes:"+ Arrays.toString(bytes));

        String s = "17";
        System.out.println("11001110:    "+(byte)Integer.parseInt(s,8));
    }


    public static int TEST(int atest, String btest) {
        int result = atest + Integer.parseInt(btest);
        return result;
    }
}
