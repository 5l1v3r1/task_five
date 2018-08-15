package com.fuwei.api;

import com.qiniu.util.Auth;

import java.io.IOException;

public class QiniuDownload {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "sQjHpO-hHmg84KGNC72Xgumo0pKahWLih-FIgjm9";
    String SECRET_KEY = "hgTL4_1GpVqEHhrhTPkWdbbfQeJSTI90Qf2IHlI2";
    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //构造私有空间的需要生成的下载的链接
    String URL = "http://pd1ky707c.bkt.clouddn.com/0hc3b1n0fv_.png";

    public static void main(String args[]) throws IOException {
        new QiniuDownload().download();
    }

    public String download()  {
        //String encodedUrl = URLEncoder.encode(URL, "utf-8");
        //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
        String downloadRUL = auth.privateDownloadUrl(URL, 3600);
        System.out.println(downloadRUL);
        return downloadRUL;
    }

    //流下载
    /*public InputStream downLoad() throws IOException {
        String fileName="1c81ec35-a477-45d3-8192-2ddb418c430d.png";
        String domainOfBucket = "http://pdawol65w.bkt.clouddn.com";

        //解决文件名包含中文的问题
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        System.out.println("encodedFileName:   "+encodedFileName);
        //获得图片的地址
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        System.out.println(finalUrl);
        //转化为流
        InputStream inputStream = new URL(finalUrl).openStream();
        System.out.println(inputStream);
        return inputStream;
    }*/

}