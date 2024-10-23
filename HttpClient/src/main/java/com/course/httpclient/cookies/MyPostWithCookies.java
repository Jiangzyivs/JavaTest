package com.course.httpclient.cookies;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyPostWithCookies {

    private String url;

    //java工具类  读取配置文件
    private ResourceBundle bundle;

    //用来存储cookie信息
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void getWithCookies() throws IOException {
        String url = this.url + bundle.getString("postCookies.uri");
        HttpPost httpPost = new HttpPost(url);
        DefaultHttpClient client = new DefaultHttpClient();
        JSONObject param = new JSONObject();
        param.put("name", "jzy");
        param.put("pawd", "123456");
        StringEntity stringEntity = new StringEntity(param.toString(), "utf-8");
        httpPost.setEntity(stringEntity);
        HttpResponse execute = client.execute(httpPost);
        this.store = client.getCookieStore();
        HttpEntity entity = execute.getEntity();
        String response = EntityUtils.toString(entity, "utf-8");
        JSONObject jsonObject = new JSONObject(response);
        System.out.println(jsonObject.get("code"));
        System.out.println(jsonObject.get("data"));
        Assert.assertEquals("200", jsonObject.get("code"));
        Assert.assertEquals("登录成功", jsonObject.get("data"));

    }
}
