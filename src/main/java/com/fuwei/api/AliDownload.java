package com.fuwei.api;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.DownloadFileRequest;
import com.aliyun.oss.model.DownloadFileResult;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.IOException;

/**
 * The examples about how to enable checkpoint in downloading.
 *
 */
public class AliDownload {

    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "XXXX";
    private static String accessKeySecret = "XXXX";
    private static String bucketName = "XXXX";
    private static String key = "12.png";
    private static String downloadFile = "D:\\Code_Audit_360\\Windows壁纸\\3.jpg";


    public static void main(String[] args) throws IOException {

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        try {
            DownloadFileRequest downloadFileRequest = new DownloadFileRequest(bucketName, key);
            // Sets the local file to download to
            downloadFileRequest.setDownloadFile(downloadFile);
            // Sets the concurrent task thread count 5. By default it's 1.
            downloadFileRequest.setTaskNum(5);
            // Sets the part size, by default it's 100K.
            downloadFileRequest.setPartSize(1024 * 1024 * 1);
            // Enable checkpoint. By default it's false.
            downloadFileRequest.setEnableCheckpoint(true);

            DownloadFileResult downloadResult = ossClient.downloadFile(downloadFileRequest);

            ObjectMetadata objectMetadata = downloadResult.getObjectMetadata();
            System.out.println(objectMetadata.getContentDisposition()+"11111111");

            System.out.println(objectMetadata.getETag());
            System.out.println(objectMetadata.getLastModified());
            System.out.println(objectMetadata.getUserMetadata().get("meta"));

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
    }
}