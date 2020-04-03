package com.fuwei.api;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendMail {


    //邮件使用的是这个模板(触发失效的这个)
    public static boolean send_template(String email, String emailcode) throws Throwable {
        final String url = "http://api.sendcloud.net/apiv2/mail/send";

        final String apiUser = "XXXX";
        final String apiKey = "XXXX";
        final String rcpt_to = email;

        String subject = "Email验证码";
        String html = "\""+email+"你好,邮箱的验证码是  "+ emailcode +"  五分钟后失效,请及时认证!!!";

        HttpPost httpPost = new HttpPost(url);
        HttpClient httpClient = new DefaultHttpClient();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", rcpt_to));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "TheLostWorld_本王"));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", html));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            System.out.println(EntityUtils.toString(response.getEntity()));
            httpPost.releaseConnection();
            return true;
        } else {
            System.err.println("error");
            return false;
        }

    }


    public static void main(String[] args) throws Throwable {
        //send_common();
        // send_common_advanced();
        send_template("XXXX@qq.com","1234");
        // send_with_addresslist();
    }
}
