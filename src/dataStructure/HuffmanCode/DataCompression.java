package dataStructure.HuffmanCode;

import java.util.Arrays;

public class DataCompression {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("code");
        StringBuilder sbs = new StringBuilder(sb);

        sbs.append("_huffman");

        System.out.println(sbs);

//        将字符转为相应的ASCII码
        byte[] bytes = "hello, welcome to my world".getBytes();
        System.out.println("bytes:"+ Arrays.toString(bytes));

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes){
            int temp = b;
            temp |= 256;//返回的是temp对应的二进制的补码
            String str = Integer.toBinaryString(temp);
            stringBuilder.append(str.substring(str.length()-8));
        }
        System.out.println("binaryByteString:" + stringBuilder.toString());

        String s = "17";
        System.out.println("11001110:    "+(byte)Integer.parseInt(s,10));
    }


    public static int TEST(int atest, String btest) {
        int result = atest + Integer.parseInt(btest);
        return result;
    }
}
