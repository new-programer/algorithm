package javaBasic.IOTest.StreamTest;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径，output：D:\JavaProjects\algorithm

        System.out.println(InputStreamTest.class.getPackage().getName()); //output：javaBasic.IOTest.StreamTest
        File directory = new File("InputStreamTest.java");
        directory.getCanonicalPath(); //得到的是C:\test\abc
        directory.getAbsolutePath();    //得到的是C:\test\abc
        directory.getPath();                    //得到的是abc

        //创建对象并指出所要读的文件位置和名称
        FileInputStream fis = new FileInputStream("src\\javaBasic\\IOTest\\StreamTest\\InputStreamTest.java");
        FileReader fr = new FileReader("src\\javaBasic\\IOTest\\StreamTest\\InputStreamTest.java");
        byte[] bbuf = new byte[1024];
        int len;//保存读取的字节数
        while((len = fis.read(bbuf))>0){
            //将读到得数据打印出来
            System.out.print(new String(bbuf,0,len));
        }
/*        while((len = fis.read())>0){
            //将读到得数据打印出来
            System.out.println(len);
        }*/
/*        while((len = fr.read())>0){
            //将读到得数据打印出来
            System.out.print(len);
        }*/
        fis.close();
    }
}
