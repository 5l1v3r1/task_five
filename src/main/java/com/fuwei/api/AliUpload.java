package com.fuwei.api;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CompleteMultipartUploadResult;
import com.aliyun.oss.model.UploadFileRequest;
import com.aliyun.oss.model.UploadFileResult;

import java.io.IOException;

/**
 * Examples of uploading with enabling checkpoint file.
 *
 */
public class AliUpload {

    private static String endpoint = "XXXX";
    private static String accessKeyId = "XXXX";
    private static String accessKeySecret = "XXX";
    private static String bucketName = "XXXX";
    private static String key = "XXXX.png";
    private static String uploadFile = "http://XXXX.bkt.clouddn.com/1c81ec35-a477-45d3-8192-2ddb418c430d.png";

    public static void main(String[] args) throws IOException {

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        try {
            UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, key);
            // The local file to upload---it must exist.
            uploadFileRequest.setUploadFile(uploadFile);//new QiniuDownload().downLoad()
            // Sets the concurrent upload task number to 5.
            uploadFileRequest.setTaskNum(5);
            // Sets the part size to 1MB.
            uploadFileRequest.setPartSize(1024 * 1024 * 1);
            // Enables the checkpoint file. By default it's off.
            uploadFileRequest.setEnableCheckpoint(true);

            UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);

            CompleteMultipartUploadResult multipartUploadResult =
                    uploadResult.getMultipartUploadResult();
            System.out.println(multipartUploadResult.getETag());

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
