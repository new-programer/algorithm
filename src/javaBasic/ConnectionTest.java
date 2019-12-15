package javaBasic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ConnectionTest {
    public static void main(String[] args) {

        Collection c = new ArrayList();
        c.add("电视机");
        c.add("空调");
        c.add(6666);

        System.out.println(c);
        c.remove(6666);
        System.out.println(c);

        c.add("水浒传");

        Collection books = new HashSet();
        books.add("金品梅");
        books.add("水浒传");

        System.out.println("books:\n"+books);

        c.add(books);
        System.out.println("c:\n"+c);
        System.out.println("c.contains(books):"+c.contains(books));
        System.out.println("c.containsAll(books)"+c.containsAll(books));


        //用forEach遍历
        System.out.println("\n\n以下为LAMBDa的forEach遍历");
        c.forEach(obj-> System.out.println("迭代c中的元素：" + obj));

        //再用Iterator遍历
        System.out.println("------------分割线-------------");
        Iterator it = c.iterator();
        it.forEachRemaining(obj-> System.out.println("iterator遍历："+obj));

        //再用foreach
        System.out.println("------------分割线-------------");
        for(Object object : c){
            System.out.println("foreach:"+object);
        }
    }
}
