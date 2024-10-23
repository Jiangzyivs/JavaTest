package com.javatest.testng;

import org.testng.annotations.Test;

public class ExpectedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        RuntimeException runtimeException = new RuntimeException();
        System.out.println("这是一个成功的异常测试" + runtimeException);
        throw runtimeException;
    }

}
