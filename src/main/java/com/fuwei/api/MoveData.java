package com.fuwei.api;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class MoveData {

    //获取阿里全部的文件名
    public static List<OSSObjectSummary> getAllFileName() {

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "XXXX";
        String accessKeySecret = "XXXX";
        String bucket = "XXXX";

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucket);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());

        }
// 关闭OSSClient。
        ossClient.shutdown();
        return sums;
    }

    //阿里云下载类
    public InputStream  AlidownLoad(String fileName) {

       // String fileName="16dd9c9e-6646-4536-b8ab-0089f4bca8bf.png";
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "XXXX";
        String accessKeySecret = "XXXX";
        String bucket="XXXX";

        try {
// 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            System.out.println("ossClient:      "+ossClient);
            // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
            OSSObject ossObject = ossClient.getObject(bucket, fileName);
            System.out.println("ossObject:     "+ossObject);
            InputStream inputStream=ossObject.getObjectContent();
            System.out.println("inputStream:    "+inputStream);
            return inputStream;
        }catch(Exception e){
            System.out.println("1111111111111111111111111111111111");
        }
        return null;
    }

    //阿里流上传
    public void  Aliupload(InputStream inputStream,String fileName) {
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "XXXX";
        String accessKeySecret = "XXXX";
        String bucketname="XXXX";

        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            /*InputStream inputStream = new FileInputStream(filePath);*/
            ossClient.putObject(bucketname, fileName, inputStream/*new File(filePath)*/);
            inputStream.close();
            ossClient.shutdown();
        } catch (OSSException oe) {
            System.out.println("Caught an upLoad OSSException," + "the error code is " + oe.getErrorCode() + "," + "reason is " + oe.getMessage());
        }catch (IOException e) {
            System.out.println("File upload problem,throw a IOException");
        }
    }


    //阿里迁移到七牛云
    public void AlitoQiniu() throws IOException {
        List<OSSObjectSummary> fileName=MoveData.getAllFileName();
        for (OSSObjectSummary filename:fileName){
            System.out.println(filename.getKey()+"++++++++++++++++++++");
           new MoveData().Qiniuupload(AlidownLoad(filename.getKey()),filename.getKey());

        }

    }
    //获取七牛云全部的文件名
    public static FileInfo[] getAllFileName1() {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        String accessKey = "sQjHpO-XXXX-FIgjm9";
        String secretKey = "XXXX";
        String bucket = "XXXX";//七牛云的bucket名称
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //文件名前缀
        String prefix = "";
        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        FileInfo[] items = new FileInfo[0];
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            items = fileListIterator.next();
            for (FileInfo item : items) {
                System.out.println(item.key+"----");
                System.out.println(item.hash);
                System.out.println(item.fsize);
                System.out.println(item.mimeType);
                System.out.println(item.putTime);
                System.out.println(item.endUser);
            }
        }
        return items;
    }

    //七牛云下载类
    public InputStream QiniudownLoad(String fileName) throws IOException {
        //String fileName="1c81ec35-a477-45d3-8192-2ddb418c430d.png";
        String domainOfBucket = "http://XXXX.bkt.clouddn.com/";

        //解决文件名包含中文的问题
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        System.out.println("encodedFileName:   "+encodedFileName);
        //获得图片的地址
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        System.out.println(finalUrl);
        //转化为流
        InputStream inputStream=new URL(finalUrl).openStream();
        System.out.println(inputStream);
        return inputStream;
    }

    //七牛云流上传
    public void  Qiniuupload(InputStream inputStream,String filename) {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKeyId = "sQjHpO-XXXX-FIgjm9";
        String accessKeySecret = "XXXX";
        String bucket = "XXXX";
        String key = filename;

        try {
//            byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
//            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKeyId, accessKeySecret);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(inputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
//ignore
                }
            }
        } catch (Exception ex) {
//ignore
        }

    }
    //七牛云迁移到阿里
    public void QiniutoAli() throws IOException {
        FileInfo[] items=MoveData.getAllFileName1();
        for (FileInfo item : items){
            System.out.println(item.key+"++++++++++++++++++++");
            new MoveData().Aliupload(QiniudownLoad(item.key),item.key);

        }

    }

    public static void main(String[] args)  throws Exception {
        //阿里迁移到七牛云
        //new MoveData().AlitoQiniu();
        //七牛云迁移到阿里
        new MoveData().QiniutoAli();
    }
}
