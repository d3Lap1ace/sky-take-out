package com.sky.controller.admin;

import com.sky.minio.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @classname sky-take-out
 * @Auther d3Lap1ace
 * @Time 17/6/2024 下午11:09 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@RestController
@RequestMapping("/admin/common")
@Api(tags = "上传图片")
@Slf4j
public class CommonController {
    @Autowired
    private MinioProperties minioProperties;
    @Autowired
    private MinioClient minioClient;

    @PostMapping("/upload")
    @Operation(description = "文件上传")
    public String upload(MultipartFile file) {
        try{
            log.info("文件上传:{}", file.getOriginalFilename());
            // 判断服务器中某个桶是否存在
            boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
            // 如果不存在就创建桶
            if(!exists){
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());
            }
            // 获取上传文件名 + 使用UUID随机生成一个字符串作为文件的前缀  + 格式化当期日期
            String newFileName = DateFormatUtils.format(new Date(),"yyyy/MM/dd")+UUID.randomUUID().toString().replaceAll("-","")+file.getOriginalFilename();
            //获取输入流
            InputStream is = file.getInputStream();
            //创建PutObjectArgs对象
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    //设置桶的名字
                    .bucket(minioProperties.getBucketName())
                    //指定上传到Minio服务器上之后的名字
                    .object(newFileName)
                    .stream(is,is.available(),-1)
                    .build();
            //通过客户端向Minio服务器上传对象
            minioClient.putObject(putObjectArgs);
            //返回文件在minio的地址，http://192.168.1.2:9000/lease/文件名
            return minioProperties.getEndpoint()+"/"+minioProperties.getBucketName()+"/"+newFileName;
        } catch (Exception e) {
            System.out.println("Error occurred:" + e);
        }
        return null;
    }
}
