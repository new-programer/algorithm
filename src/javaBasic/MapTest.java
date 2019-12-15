package javaBasic;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        //即键值都是String类
        Map<String, String> map = new HashMap<>();

        map.put("hello","world");
        map.put("good","morning");

        System.out.println("map:\n"+map);

        for(Object entry: map.entrySet()){
            System.out.println(entry);
        }

        System.out.println("-------------分割线-------------");

        for (Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
//        map.forEach(obj-> System.out.println("map's obj:\n"+obj));
    }
}
