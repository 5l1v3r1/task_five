package com.fuwei.api;
import com.fuwei.des.CharacterUtils;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class QIniuUpload {


    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "sQjHpO-XXXX-FIgjm9";
    String SECRET_KEY = "XXXX";
    //要上传的空间
    String bucketname = "thelostworld1";
    //上传到七牛后保存的文件名
    //String key = "head_fv_.png";
    //上传文件的路径
   // String FilePath = "D:\\Code_Audit_360\\Windows壁纸\\星空.jpg";
    private  String CDN_DOMAIN_NAME ="http://pd1ky707c.bkt.clouddn.com/";
    //上传根目录
    private  String IMG_UPLOAD_PATH = "";

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    private  Zone z = Zone.autoZone();
    private  Configuration c = new Configuration(z);

    //创建上传对象
    private  UploadManager uploadManager = new UploadManager(c);

    public String uploadImg2QiNiu(MultipartFile file) throws IOException {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH:mm:ss.SSS");
        String name_file = CharacterUtils.getRandomString2(8);//随机数
        String key = IMG_UPLOAD_PATH +name_file+"fv_.png";
        try {
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(bucketname);
            Response response = uploadManager.put(file.getInputStream(), key, upToken,null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return CDN_DOMAIN_NAME + putRet.key;
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            //System.out.println(r.toString());
            try {
// 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                e.printStackTrace();
            }
            return "上传图片异常!";
        }
    }
}
