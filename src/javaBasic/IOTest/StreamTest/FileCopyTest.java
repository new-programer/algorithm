package javaBasic.IOTest.StreamTest;

import java.io.*;
import java.math.BigDecimal;
import java.util.function.BiFunction;
/*1.字节流操作
文件复制用时：5ms*/
/*
public class FileCopyTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\qq812\\Desktop\\深度神经网络并行化研究综述.pdf");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\qq812\\Desktop\\临时复制文件.pdf");
        byte[] bbuf = new byte[1024];
        int fisLen;

        long startTime = System.currentTimeMillis();
        while((fisLen=fis.read(bbuf))>0){
            fos.write(bbuf);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("pdf文件复制成功");
        System.out.println("文件复制用时：" + (endTime-startTime));
        fis.close();
        fos.close();
    }
}
*/
/*2.字符流操作
文件复制用时：92ms*/
/*
public class FileCopyTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\qq812\\Desktop\\深度神经网络并行化研究综述.pdf");
        FileWriter fw = new FileWriter("C:\\Users\\qq812\\Desktop\\临时PDF文件(字符流读写).pdf");
        char[] cbuf = new char[1024];
        int fisLen;

        long startTime = System.currentTimeMillis();
        while((fisLen=fr.read(cbuf))>0){
            fw.write(cbuf);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("pdf文件复制成功");
        System.out.println("文件复制用时：" + (endTime-startTime));
        fr.close();
        fw.close();
    }
}*/

/*3.带缓存字符流操作
文件复制用时：2ms*/
public class FileCopyTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        try {
            bufr = new BufferedReader(new FileReader("C:\\Users\\qq812\\Desktop\\详细报表.txt"));
            bufw = new BufferedWriter(new FileWriter("C:\\Users\\qq812\\Desktop\\BUFFIRECOPY.txt"));
        }catch (FileNotFoundException fnfe) {
            System.out.println("文件未找到");

        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }finally {
            if (bufr != null){
                bufr.close();
            }
           if(bufw != null) {
               bufw.close();
           }

        }



        String str = null;
        long startTime = System.currentTimeMillis();
        /*注意含有缓存区的读写流具有readline(),newLine(),flush()三个特殊的方法*/
        while((str=bufr.readLine()) != null){
            bufw.write(str);
            bufw.newLine();

        }
        bufw.flush(); //这一条必须具备
        long endTime = System.currentTimeMillis();
        System.out.println("pdf文件复制成功");
        System.out.println("文件复制用时：" + (endTime-startTime));

    }
}



