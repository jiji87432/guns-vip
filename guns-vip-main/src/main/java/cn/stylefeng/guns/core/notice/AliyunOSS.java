package cn.stylefeng.guns.core.notice;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import cn.stylefeng.guns.config.ConfigEntity;
import cn.stylefeng.guns.core.DateUtils;
import cn.stylefeng.guns.core.UUIDGenerator;
import cn.stylefeng.guns.core.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AliyunOSS {

	@Resource
	private ConfigEntity configEntity;
	
	public String upload(MultipartFile file) {
		String endpoint = "oss-cn-hangzhou.aliyuncs.com";
		String accessKeyId = configEntity.getAliyunAccessKeyId();
		String accessKeySecret = configEntity.getAliyunSecret();
		String bucketName = configEntity.getAliyunBucketName();
		String bucketUrl = configEntity.getAliyunBucketUrl();
		
		// 获取文件信息
		String fileName = file.getOriginalFilename();
		String extension = FilenameUtils.getExtension(fileName);
		String key = DateUtils.getCurrentTime(DateUtils.YYYY_MM_DD_HH_MM_SS_SSS_PATTERN) + UUIDGenerator.get32UUID()
		+ "." + extension;
		try {
			// 创建OSSClient实例
			OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
			// 上传到指定存储空间
			ossClient.putObject(bucketName, key, file.getInputStream());
			// 关闭OSSClient。
			ossClient.shutdown();
			return bucketUrl + key;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage());
		}
	}
}
