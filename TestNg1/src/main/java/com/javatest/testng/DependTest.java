package com.javatest.testng;

import org.testng.annotations.Test;

public class DependTest {

    private String a;

    @Test
    public void test1(){
        System.out.println("test1 run");
    }

    @Test
    public void test2(){
        a = "jzy";
    }

    @Test(dependsOnMethods = {"test2"})
    public void test3(){
        System.out.println(a);
    }


}
