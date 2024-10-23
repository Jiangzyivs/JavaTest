package com.javatest.testng.paramter;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name = " + name + "; age = " + age);
    }

    @DataProvider(name = "data")
    public Object[][] provider() {
        Object[][] o = new Object[][]{
                {"jzy",27},
                {"zhangsan",27},
                {"wangwu",28}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name, int age){
        System.out.println("test1方法的name = " + name + "； age  = " +age );
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age){
        System.out.println("test2方法的name = " + name + "； age  = " +age );
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"张三",20},
                    {"李四",21}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",61}
            };
        }
        return result;
    }

    @Test(dataProvider = "Stringdata")
    public void getSting(UserTest userTest){
        System.out.println(userTest);
        System.out.println(userTest.getName());
    }



    @DataProvider(name = "Stringdata")
    public Object[][] getString(){
        UserTest userTest = new UserTest();
        UserTest userTest1 = new UserTest();
        userTest.setName("jzy");
        userTest.setAge(27);
        userTest1.setName("lchm");
        userTest1.setAge(29);
        return new Object[][]{
                {userTest},
                {userTest1}
        };
    }


}
