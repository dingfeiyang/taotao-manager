package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.util.JsonUtils;
import com.taotao.service.PictureService;

/**
 * 
 * Create by dingfeiyang
 * 
 * 2018年10月23日
 * 
 * 上传图片处理
 */
@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile){
		Map result = pictureService.uploacPicture(uploadFile);
		//为了保证功能的兼容性，需要吧result转化成json格式的字符串
		String json = JsonUtils.objectToJson(result);
		return json;
	}
	
}