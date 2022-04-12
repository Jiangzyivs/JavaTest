package com.javatest.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {

    @Test
    @Parameters({"name","age"})
    public void paramterTest1(String name,int age){
        System.out.println("name = " + name + ", age = " + age);
    }

    @Test
    @Parameters("ddd")
    public void pring11(int a){
        System.out.println(a);
    }

}
