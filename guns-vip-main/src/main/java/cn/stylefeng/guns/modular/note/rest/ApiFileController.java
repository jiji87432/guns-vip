package cn.stylefeng.guns.modular.note.rest;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.stylefeng.guns.config.ConfigEntity;
import cn.stylefeng.guns.core.FileUtil;
import cn.stylefeng.guns.core.ResultGenerator;
import cn.stylefeng.guns.core.UploadUtils;
import cn.stylefeng.guns.core.exception.ServiceException;
import cn.stylefeng.guns.core.notice.AliyunGreen;
import cn.stylefeng.guns.core.notice.AliyunOSS;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/file")
public class ApiFileController extends ApiBaseController {

	@Resource
	private AliyunGreen aliyunGreen;
	
	@Resource
	private AliyunOSS aliyunOSS;
	
	@Resource
	private ConfigEntity configEntity;
	
	@PostMapping("/upload")
	public Object uploadImage(HttpServletRequest request, @RequestParam(required = true, name = "file") MultipartFile file) {
		String imageUrl = aliyunOSS.upload(file, configEntity.getAliyunImagesFolder());
		aliyunGreen.checkImage(imageUrl);
		log.info("/api/file/upload");
		return ResultGenerator.genSuccessResult(imageUrl);
	}
	
	@PostMapping("/uploadVoice")
	public Object uploadVoice(HttpServletRequest request, @RequestParam(required = true, name = "file") MultipartFile file) {
		String voiceUrl = aliyunOSS.upload(file, configEntity.getAliyunVoicesFolder());
		log.info("/api/file/uploadVoice");
		return ResultGenerator.genSuccessResult(voiceUrl);
	}
	
	@PostMapping("/checkText")
	public Object checkText(String text) {
		aliyunGreen.checkText(text);
		log.info("/api/file/checkText");
		return ResultGenerator.genSuccessResult();
	}
	
	@PostMapping("/uploadPackage")
	public Object uploadPackage(HttpServletRequest request, @RequestParam(required = true, name = "file") MultipartFile file) {
		String packageUrl = aliyunOSS.upload(file, configEntity.getAliyunGiftFolder());
		log.info("/api/file/uploadPackage");
		return ResultGenerator.genSuccessResult(packageUrl);
	}
	
	public String saveImage(MultipartFile file, String folderName) throws IllegalStateException, IOException  {
		if (file.isEmpty()) {
			throw new ServiceException("上传文件为空");
		}
		if (!FileUtil.checkFileSize(file.getSize(), 10, "M")) {
			throw new ServiceException("图片不能超过10M");
		}
		String absolutePath = configEntity.getAbsoluteUploadPath() + File.separator + folderName;
		FileUtil.createPath(absolutePath);
		String name = UploadUtils.uploadFile(file, absolutePath);
		String relativePath = folderName + File.separator + name;
		return relativePath;
	}
}
