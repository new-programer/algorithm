package javaBasic.IOTest.StreamTest;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class StreamTransferTest {
    public static void main(String[] args) {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try{
            isr = new InputStreamReader(System.in);
            osw = new OutputStreamWriter(System.out);

//            Scanner in = new Scanner(System.in);
//            String string = in.nextLine();

            char[] str = new char[1024];

            while (isr.read(str)>0){
                osw.write(str);
                System.out.println(str);
            }
        }catch (Exception e)
        {
            System.out.println("输出结果：");
            System.out.println(e.getStackTrace());
        }



    }
}
