package javaBasic;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("和萨芬 啊1");
        set.add("和萨芬 啊2");
        set.add("和萨芬 啊f f s fs fs");
        set.add("和萨芬 啊32");
        set.add("和萨芬 啊f ffsfsfsf");

        System.out.println("原set:foreach输出");
        for (Object e : set) {
            System.out.println(e + ":" + e.toString().length());
        }

        System.out.println("------------分割线---------------");
        Vector v = new Vector();
        v.add("和萨芬 啊1");
        v.add("和萨芬 啊2");
        v.add("和萨芬 啊f f s fs fs");
        v.add("和萨芬 啊32");
        v.add("和萨芬 啊f ffsfsfsf");
        System.out.println("v:enumeration迭代方式遍历古老的集合Vector和Hashtalbe");

        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

        System.out.println("------------分割线---------------");

        /*进行长度选择过滤*/
        set.removeIf(ele -> (((String) ele).length() < 7));

        System.out.println("新set");
        Iterator it = set.iterator();
        it.forEachRemaining(obj -> System.out.println("iterator:" + obj));

        //特殊过滤
        System.out.println("set中含有fs两字母的元素：" + calAll(set, ele->((String)ele).contains("fs")));

    }

    public static int calAll(Set s, Predicate p) {
        int total = 0;
        for (Object object : s) {
            if (p.test(object)) {
                total++;
            }
        }
        return total;
    }
}