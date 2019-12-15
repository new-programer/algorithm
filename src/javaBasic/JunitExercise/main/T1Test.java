package javaBasic.JunitExercise.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class T1Test extends T1 {

    @Test
    public void testAdd() {
        T1 t = new T1();
        int z = t.add(3,5);
        assertEquals("返回结果和预期值不相等",8,z);
    }

    @Test
    public void testSpeak() {
        T1 s = new T1();
        String str = s.speak("hello");
        assertEquals("不满足要求","hello", str);
    }
}