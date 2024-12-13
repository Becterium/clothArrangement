package com.hehe.boot.Utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
//    public static  final String ALI_DOMAIN = "https://cloth-system.oss-cn-beijing.aliyuncs.com/";

    public  static  String uploadImage(MultipartFile file) throws IOException {
        String originFilename = file.getOriginalFilename();
        String ext = "."+ FilenameUtils.getExtension(originFilename);
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileName = uuid+ext;

        //配置阿里的对象存储服务
//        String endpoint = "";
//        String accessKeyId = "";
//        String accessKeySecret="";

        OSS ossClient= new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(
                "cloth-system",
                fileName,
                file.getInputStream()
        );
        ossClient.shutdown();
        return  ALI_DOMAIN + fileName;
    }

}
