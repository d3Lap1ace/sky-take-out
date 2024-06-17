package com.sky.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @classname sky-take-out
 * @Auther d3Lap1ace
 * @Time 17/6/2024 下午11:04 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
@Data
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
