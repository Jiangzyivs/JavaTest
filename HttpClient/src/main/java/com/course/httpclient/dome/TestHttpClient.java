package com.course.httpclient.dome;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class TestHttpClient {

    @Test
    public void test1(){
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpClient client = new DefaultHttpClient();
        try {
            HttpResponse res = client.execute(get);
            result = EntityUtils.toString(res.getEntity());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
