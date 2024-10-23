package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;

    //java工具类  读取配置文件
    private ResourceBundle bundle;

    //用来存储cookie信息
    private CookieStore store;


    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    @Test
    public void testGetCookies() throws IOException{
        String result;
        String uri = bundle.getString("getCookies.uri");
        String getCookiesUrl = this.url + uri;
        HttpGet get = new HttpGet(getCookiesUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        this.store = client.getCookieStore();
        for(Cookie cookie : client.getCookieStore().getCookies()){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException{
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        System.out.println(testUrl);
        HttpGet httpGet = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookie
        client.setCookieStore(this.store);
        System.out.println(this.store);
        HttpResponse response = client.execute(httpGet);
        System.out.println(response);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if (200==statusCode){
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }

}
