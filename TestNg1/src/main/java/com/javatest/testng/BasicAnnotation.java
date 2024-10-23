package com.javatest.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testcase1(){
        System.out.printf("Thread Id :%s%n ",Thread.currentThread().getId());
        System.out.println("这是测试1");
    }

    @Test
    public void testcase2(){
        System.out.printf("Thread Id :%s%n ",Thread.currentThread().getId());
        System.out.println("这是测试2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是测试之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是测试之后运行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("类运行之前运行的方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("类运行之后运行的方法");
    }


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }


}
